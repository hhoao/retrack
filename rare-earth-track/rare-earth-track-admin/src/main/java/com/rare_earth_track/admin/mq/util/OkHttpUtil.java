package com.rare_earth_track.admin.mq.util;

import com.alibaba.fastjson.JSONObject;
import com.rare_earth_track.mgb.model.RetDataReleased;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zgr
 * @version 1.0
 * @date 2022/7/7 20:19
 */
@Slf4j
@Component
public class OkHttpUtil {
    @Autowired
    private Environment env;
    @Autowired
    private OkHttpClient client;

//    @Autowired
//    public OKHttpUtil(Environment env, OkHttpClient client) {
//        this.env = env;
//        this.client = client;
//    }

    public Integer postData(String... commands) {
        //初始化url
        String url = initUrl();
        System.out.println(url);
        //初始化JSON
        String json = initJSON(commands);
        //发送并得到响应结果
        return post(url, json);
    }

    private Integer post(String url, String json) {
        //发送并得到响应结果
//        String responseBody = "";

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .addHeader("Content-Type", env.getProperty("header.content-type"))
                .addHeader("api-key", env.getProperty("machine.apiKey"))
                .build();
        try (Response response = this.client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return 1;
            }
        } catch (Exception e) {
            log.error("{}", e);
        }
        return -1;
    }


    /**
     * 初始化JSON
     *
     * @param commands
     * @return
     */
    private String initJSON(String[] commands) {
        // 构建 request body 中的 json 字符串
        HashMap<String, List> map = new HashMap<>();
        List<RetDataReleased> datas = new ArrayList<>();
        System.out.println();
        for (String command : commands) {
            datas.add(RetDataReleased.builder()
                    .res_id(Integer.parseInt(env.getProperty("body.res_id")))
                    .val(command)
                    .build());
        }
        map.put("data", datas);
        return JSONObject.toJSONString(map);
    }

    /**
     * 初始化url
     *
     * @return
     */
    private String initUrl() {
        //存放参数的容器
        HashMap<String, String> paramMap = new HashMap<>();
        System.out.println(env);
        //设置参数
        paramMap.put("imei", env.getProperty("params.imei"));
        paramMap.put("obj_id", env.getProperty("params.obj_id"));
        paramMap.put("obj_inst_id", env.getProperty("params.obj_inst_id"));
        paramMap.put("mode", env.getProperty("params.mode"));
        paramMap.put("timeout", env.getProperty("params.timeout"));
        //转化url形式并返回
        return parseUrl(paramMap);
    }

    /**
     * 将 Map 映射到 Url 参数中
     *
     * @param params 参数 Map
     * @return String
     */
    private String parseUrl(HashMap<String, String> params) {
        StringBuilder sb = new StringBuilder("http://api.heclouds.com/nbiot?");
        for (String key : params.keySet()) {
            sb.append(key).append("=").append(params.get(key)).append("&");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

}