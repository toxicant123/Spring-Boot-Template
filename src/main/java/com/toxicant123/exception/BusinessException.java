package com.toxicant123.exception;

import lombok.Data;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-27 下午11:33
 */
@Data
public class BusinessException extends RuntimeException {

    private Integer code;

    private String message;

}
