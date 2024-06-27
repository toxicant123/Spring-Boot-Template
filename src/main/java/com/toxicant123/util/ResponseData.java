package com.toxicant123.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-27 下午11:21
 */
@Data
public class ResponseData<T> {

    private Integer code;

    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time;

    private T data;
}
