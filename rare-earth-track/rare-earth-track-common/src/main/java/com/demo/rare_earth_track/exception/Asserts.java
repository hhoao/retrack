package com.demo.rare_earth_track.exception;


import com.demo.rare_earth_track.api.IErrorCode;

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
