package com.rare_earth_track.admin.util;

/**
 * @ClassName UploadUtils
 * @Description: 文件名称替换工具，将文件名称替换为随机名称
 * @Author 匡龙
 * @Date 2022/6/21 20:09
 * @Version V1.0
 */
public class UploadUtils {

    /**
     * 文件名称替换工具，将文件名称替换为随机名称
     * @param oldName
     * @return
     */
    public static String generateFileName(String oldName){
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        return IDUtils.generateUniqueId()+suffix;
    }

}
