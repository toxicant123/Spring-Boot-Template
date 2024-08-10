package com.toxicant123.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-06 下午9:13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractCheckedBusinessException extends Exception implements BusinessExceptionInterface {

    protected String errorCode;

    protected String errorMessage;

    protected String userMessage;

    protected HttpStatus httpStatus;
}
