package com.rare_earth_track.admin.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.lang.UUID;
import com.github.pagehelper.PageHelper;
import com.rare_earth_track.admin.bean.PageInfo;
import com.rare_earth_track.admin.service.RetFileService;
import com.rare_earth_track.mgb.mapper.RetFileMapper;
import com.rare_earth_track.mgb.model.RetFile;
import com.rare_earth_track.mgb.model.RetFileExample;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * @ClassName RetFileServiceImpl
 * @Description: 文件接口的实现类
 * @Author 匡龙
 * @Date 2022/6/22 14:42
 * @Version V1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RetFileServiceImpl implements RetFileService {
    private final RetFileMapper fileMapper;

    @Value("${file.upload.path}")
    private String filesUploadPath;//获取文件路径
    @Value("${file.upload.baseUrl}")
    private String baseUrl;



    @Override
    public List<RetFile> getFileList(PageInfo pageInfo, RetFile queryFile) {
        PageHelper.startPage(pageInfo.getPageNum(), pageInfo.getPageSize());
        RetFileExample fileExample = getFileExample(queryFile);
        List<RetFile> files = fileMapper.selectByExample(fileExample);
        return files;
    }

    private RetFileExample getFileExample(RetFile queryFile) {
        RetFileExample fileExample = new RetFileExample();
        if (queryFile != null){
            RetFileExample.Criteria criteria = fileExample.createCriteria();
            if (StringUtils.hasLength(queryFile.getFileName())){
                criteria.andFileNameEqualTo(queryFile.getFileName());
            }
            if (queryFile.getId() != null){
                criteria.andIdEqualTo(queryFile.getId());
            }
            if (StringUtils.hasLength(queryFile.getUrl())){
                criteria.andUrlEqualTo(queryFile.getUrl());
            }
            if (StringUtils.hasLength(queryFile.getUuid())){
                criteria.andUrlEqualTo(queryFile.getUuid());
            }
            if (queryFile.getEnable() != null){
                criteria.andEnableEqualTo(queryFile.getEnable());
            }
            if (StringUtils.hasLength(queryFile.getType())){
                criteria.andTypeEqualTo(queryFile.getType());
            }
        }
        return fileExample;
    }

    @Override
    public String upload(MultipartFile file) {
        //将相对路径转化为绝对路径
        String destPath = new File(filesUploadPath).getAbsolutePath();
        //文件夹路径名称
        String originalFilename = file.getOriginalFilename();
        //文件大小
        double size = file.getSize();
        //文件类型
        String type = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();

        //使用uuid生成随机唯一值
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //新的文件名称，uuid+文件类型
        String fileUuid = uuid + "." + type;
        //新的文件地址，绝对路径+新的文件名称
        File uploadFile = new File(destPath + "/" + fileUuid);

        //判断配置的文件目录是否存在，若不存在则创建一个新的文件目录
        File parentFile = uploadFile.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }

        try {
            String url;
            //获取文件的UUID,通过对比文件md5，防止上传相同内容的文件
            //通过UUID来查询文件
            RetFile dbRetFile = this.getFileByUUid(uuid);
            if (dbRetFile != null) {//如果数据库存在相同文件，直接获取url
                url = dbRetFile.getUrl();
            } else {//如果数据库不存在相同文件，先存储到本地磁盘，再设置文件url
                file.transferTo(uploadFile);//把获取到的文件存储带磁盘目录
                url = baseUrl + fileUuid;//设置文件url
            }

            //将文件存储到数据库
            RetFile saveFile = new RetFile();
            saveFile.setFileName(originalFilename);
            saveFile.setType(type);
            saveFile.setSize(size / 1024);//（单位：KB）
            saveFile.setUrl(url);
            saveFile.setUuid(uuid);
            saveFile.setCreateTime(DateTime.now());
            saveFile.setUpdateTime(DateTime.now());
            //保存操作
            fileMapper.insert(saveFile);

            //返回文件下载路径url
            return url;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //将文件以流的形式一次性读取到内存，通过响应输出流输出到前端
    @Override
    public void download(String filesUUID, HttpServletResponse response) {
        try {
            //根据文件的唯一标识码获取文件
            File uploadFile = new File(filesUploadPath + filesUUID);

            //读取文件的字节流
            FileInputStream fileInputStream = new FileInputStream(uploadFile);
            //将文件写入输入流
            InputStream inputStream = new BufferedInputStream(fileInputStream);

            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            inputStream.close();


            //attachment表示以附件方式下载 inline表示在线打开 "Content-Disposition: inline; filename=文件名.png"
            //filename表示文件的默认名称，因为网络传输只支持URL编码的相关支付，因此需要将文件名URL编码后进行传输,前端收到后需要反编码才能获取到真正的名称
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filesUUID, "UTF-8"));
            response.setContentType("application/octet-stream");

            //设置输出流的格式
            ServletOutputStream os = response.getOutputStream();
            os.write(buffer);

            //关闭
            fileInputStream.close();
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("文件下载出错", e);
        }
    }

    @Override
    public void deleteFileById(Long id) {
        try {
            RetFile retFile = fileMapper.selectByPrimaryKey(id);
            Path path = Path.of(filesUploadPath + retFile.getUuid()+"."+retFile.getType());
            Files.deleteIfExists(path);
            fileMapper.deleteByPrimaryKey(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //通过文件uuid查询文件
    private RetFile getFileByUUid(String uuid) {
        //查找数据库是否已经存在一样的图片
        RetFileExample fileExample = new RetFileExample();
        fileExample.createCriteria().andUuidEqualTo(uuid);
        List<RetFile> retFileList = fileMapper.selectByExample(fileExample);
        return retFileList.size() == 0 ? null : retFileList.get(0);
    }
}

