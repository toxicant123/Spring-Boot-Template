package com.toxicant123.exception;

import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
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
public abstract class AbstractUncheckedBusinessException extends RuntimeException implements BusinessExceptionInterface {

    protected String errorCode;

    protected String errorMessage;

    protected String userMessage;

    protected HttpStatus httpStatus;

    public AbstractUncheckedBusinessException() {

    }

    public AbstractUncheckedBusinessException(String errorCode, String errorMessage, String userMessage, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.userMessage = userMessage;
        this.httpStatus = httpStatus;
    }

    public AbstractUncheckedBusinessException(ErrorCodeAndUserMessageEnum errorCodeAndUserMessageEnum, String errorMessage) {
        this.errorCode = errorCodeAndUserMessageEnum.name();
        this.errorMessage = errorMessage;
        this.userMessage = errorCodeAndUserMessageEnum.getUserMessage();
        this.httpStatus = errorCodeAndUserMessageEnum.getHttpStatusCode();
    }

}
