package com.rare_earth_track.admin.util;

import cn.hutool.core.lang.UUID;

/**
 * @ClassName IDUtils
 * @Description: 唯一ID生成器，可以生成唯一ID
 * @Author 匡龙
 * @Date 2022/6/21 20:11
 * @Version V1.0
 */
public class IDUtils {

    /**
     * 唯一ID生成器，可以生成唯一ID
     * @return
     */
    public static String generateUniqueId() {
        return UUID.randomUUID().toString()+System.currentTimeMillis();
    }

}
