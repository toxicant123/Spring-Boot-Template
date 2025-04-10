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
public abstract class AbstractUncheckedExternalException extends RuntimeException implements BusinessExceptionInterface {

    protected String errorCode;

    protected String errorMessage;

    protected String userMessage;

    protected HttpStatus httpStatus;

    public AbstractUncheckedExternalException(ErrorCodeAndUserMessageEnum errorCodeAndUserMessageEnum, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCodeAndUserMessageEnum.name();
        this.errorMessage = errorMessage;
        this.userMessage = errorCodeAndUserMessageEnum.getUserMessage();
        this.httpStatus = errorCodeAndUserMessageEnum.getHttpStatusCode();
    }

    public AbstractUncheckedExternalException(ErrorCodeAndUserMessageEnum errorCodeAndUserMessageEnum, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.errorCode = errorCodeAndUserMessageEnum.name();
        this.errorMessage = errorMessage;
        this.userMessage = errorCodeAndUserMessageEnum.getUserMessage();
        this.httpStatus = errorCodeAndUserMessageEnum.getHttpStatusCode();
    }
}
