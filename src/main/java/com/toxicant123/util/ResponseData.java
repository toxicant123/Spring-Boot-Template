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

    private String errorCode = "00000";

    private String errorMessage = "success";

    private String userMessage;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time = new Date();

    private T data;

    private String uuid;

    public static <T> ResponseData<T> success(T data) {
        return new ResponseData<T>()
                .setData(data);
    }

    public static <T> ResponseData<T> fail(T data, String errorCode, String errorMessage, String userMessage, String uuid) {
        return new ResponseData<T>()
                .setData(data)
                .setErrorCode(errorCode)
                .setErrorMessage(errorMessage)
                .setUserMessage(userMessage)
                .setUuid(uuid);
    }
}
