package com.rare_earth_track.common.exception;


import com.rare_earth_track.common.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 * @author hhoa
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
