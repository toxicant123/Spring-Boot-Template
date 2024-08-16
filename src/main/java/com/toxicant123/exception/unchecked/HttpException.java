package com.toxicant123.exception.unchecked;

import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.AbstractUncheckedBusinessException;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-09 上午12:20
 */
public class HttpException extends AbstractUncheckedBusinessException {

    public HttpException(ErrorCodeAndUserMessageEnum errorCodeAndUserMessageEnum, String errorMessage) {
        super(errorCodeAndUserMessageEnum, errorMessage);
    }

    public HttpException(ErrorCodeAndUserMessageEnum errorCodeAndUserMessageEnum, String errorMessage, Throwable cause) {
        super(errorCodeAndUserMessageEnum, errorMessage, cause);
    }
}
