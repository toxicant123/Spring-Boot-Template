package com.toxicant123.exception;

import lombok.Data;

import java.util.Map;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-27 下午11:33
 */
@Data
public abstract class AbstractBusinessException extends RuntimeException {

    Integer code;

    String message;

    Map<String, Object> detail;
}
