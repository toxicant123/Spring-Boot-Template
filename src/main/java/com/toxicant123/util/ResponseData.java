package com.toxicant123.util;

import lombok.Data;

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

    private T data;
}
