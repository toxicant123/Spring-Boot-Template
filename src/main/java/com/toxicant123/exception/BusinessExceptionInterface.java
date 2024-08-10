package com.toxicant123.exception;

import org.springframework.http.HttpStatus;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-06 下午9:12
 */
public interface BusinessExceptionInterface {

    String getErrorCode();

    String getErrorMessage();

    String getUserMessage();

    HttpStatus getHttpStatus();
}
