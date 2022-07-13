package com.rare_earth_track.admin.mq.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rare_earth_track.admin.mq.constant.DataFrameHeader;
import com.rare_earth_track.admin.mq.util.OkHttpUtil;
import com.rare_earth_track.admin.mq.util.SpringContext;
import com.rare_earth_track.admin.service.RetProductService;
import com.rare_earth_track.mgb.mapper.RetProductMapper;
import com.rare_earth_track.mgb.model.RetProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author zgr
 * @version 1.0
 * @date 2022/7/6 16:59
 */
@Component
@Slf4j
public class DataHandler {

    @Autowired
    private RetProductService retProductService;
    @Autowired
    private RetProductMapper retProductMapper;

    /**
     * 测试
     * @param data
     * @throws ParseException
     */
    public void parseDataTest(String data) throws ParseException {
        JSONObject jsonObject = JSON.parseObject(data);
        String body = jsonObject.getString("body");
        log.info(body);
        String[] array = body.split(",");
        log.info("接收到数据:" + Arrays.toString(array));
        OkHttpUtil bean = SpringContext.getBean(OkHttpUtil.class);
        if ("01".equals(array[1])) {
            bean.postData("A2,01,012022070506,NFXT,Nd2O3,50g,Tong,20220706,012454,rydjf,99.0%,99.995%,YL,0.006%,0.0665%");
        } else if ("02".equals(array[1])) {
//            bean.postData("A2,02,022022070506,NFXT,Nd,50g,Tong,20220706,012454,rydjf,fbf,99.0%,99.5%,0.5%,0.68%");
            bean.postData("A2,02,022022071105");
        } else if ("03".equals(array[1])) {
            bean.postData("A2,03,032022070506,NFXT,NdFeB,50g,Tong,20220706,012454,30%,25MPa,3T,25%,15%,1.3%,15%,2%");
        }
    }

    public void parseData(String data) throws ParseException {
        JSONObject jsonObject = JSON.parseObject(data);
        String body = jsonObject.getString("body");
        log.info(body);
        String[] array = body.split(",");
        log.info("接收到数据:" + Arrays.toString(array));
        switch (array[0]) {
            case DataFrameHeader.RECEIVE_MESSAGE:
                newProductHandler(array);
                break;
            case DataFrameHeader.SEND_OUT_MESSAGE:
                break;
            default:
                break;
        }
    }

    /**
     * 处理数据方法
     *
     * @param data
     */
    @Transactional(rollbackFor = Exception.class)
    public void newProductHandler(String[] data) throws ParseException {
        RetProduct retProduct = new RetProduct();
        log.info("接收到产品数据{}", data);
        //表示是哪一个阶段
        String productionPhase = data[1];
        retProduct.setProductionPhase(productionPhase);

        //批号
        String batchId = data[2];
        retProduct.setBatchId(batchId);

        //生产厂家
        String factory = data[3];
        retProduct.setFactory(factory);

        //原料名称
        String name = data[4];
        retProduct.setName(name);

        //原料重量
        String netWeight = data[5];
        retProduct.setNetWeight(netWeight);
        //原料包装
        String packingType = data[6];
        retProduct.setPackingType(packingType);
        //出产日期
        String dispatchTime = data[7];
        String time = String.format("%s-%s-%s",dispatchTime.substring(0,4)
                ,dispatchTime.substring(4,6),dispatchTime.substring(6,8));
        log.info("time:{}",time);
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = fmt.parse(time);

        log.info("date:{}",date);
        retProduct.setDispatchTime(date);

        //产品牌号
        String standardNumber = data[8];
        retProduct.setStandardNumber(standardNumber);

        if ("01".equals(data[1])) {
            //工艺
            String miningTechnology = data[9];
            retProduct.setMiningTechnology(miningTechnology);
        } else if ("02".equals(data[1])) {
            //工艺
            String mine = data[9];
            retProduct.setMine(mine);
            String separate = data[10];
            retProduct.setSeparate(separate);
        } else if ("03".equals(data[1])) {
            //工艺
            String oxygenLevels = data[9];
            retProduct.setOxygenLevels(oxygenLevels);
            String pressure = data[10];
            retProduct.setPressure(pressure);
            String magneticField = data[11];
            retProduct.setMagneticField(magneticField);
        }
        log.info("ret:{}",retProduct);
        retProductMapper.insertByBatchId(retProduct);
        //判断产品是否存在
//        long batch_id = Long.parseLong("batch_id");
//        QueryWrapper<RetProduct> retProductQueryWrapper = new QueryWrapper<>();
//        retProductQueryWrapper.eq("batch_id", batchId);
//        RetProduct retProducts = retProductMapper.selectByPrimaryKey(batch_id);

    }

}
