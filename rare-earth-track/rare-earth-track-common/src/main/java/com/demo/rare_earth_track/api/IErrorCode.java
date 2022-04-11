package com.demo.rare_earth_track.api;

/**
 * @author hhoa
 * @date 2022/4/7
 **/
public interface IErrorCode {
    /**
     * 获取码
     * @return 码
     */
    long getCode();

    /**
     * 返回信息
     * @return 信息
     */
    String getMessage();
}
