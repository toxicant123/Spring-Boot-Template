package com.toxicant123.exception;

import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    public AbstractUncheckedBusinessException() {

    }

    public AbstractUncheckedBusinessException(String errorCode, String errorMessage, String userMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.userMessage = userMessage;
    }

    public AbstractUncheckedBusinessException(ErrorCodeAndUserMessageEnum errorCodeAndUserMessageEnum, String errorMessage) {
        this.errorCode = errorCodeAndUserMessageEnum.name();
        this.errorMessage = errorMessage;
        this.userMessage = errorCodeAndUserMessageEnum.getUserMessage();
    }

}
