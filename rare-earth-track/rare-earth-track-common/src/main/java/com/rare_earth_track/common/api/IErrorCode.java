package com.rare_earth_track.common.api;

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
