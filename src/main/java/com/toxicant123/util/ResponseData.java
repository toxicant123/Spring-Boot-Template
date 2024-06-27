package com.toxicant123.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-27 下午11:21
 */
@Data
@Accessors(chain = true)
public class ResponseData<T> {

    private Integer code;

    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time = new Date();

    private T data;

    public static <T> ResponseData<T> success(T data) {
        return success(data, "success");
    }

    public static <T> ResponseData<T> success(T data, String message) {
        return success(data, message, 200);
    }

    public static <T> ResponseData<T> success(T data, String message, Integer code) {
        return new ResponseData<T>()
                .setData(data)
                .setMessage(message)
                .setCode(code);
    }

    public static <T> ResponseData<T> fail(T data) {
        return fail(data, "fail");
    }

    public static <T> ResponseData<T> fail(T data, String message) {
        return fail(data, message, 500);
    }

    public static <T> ResponseData<T> fail(T data, String message, Integer code) {
        return new ResponseData<T>()
                .setData(data)
                .setMessage(message)
                .setCode(code);
    }

}
