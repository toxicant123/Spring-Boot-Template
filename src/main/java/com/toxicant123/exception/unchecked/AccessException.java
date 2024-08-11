package com.toxicant123.exception.unchecked;

import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.AbstractUncheckedBusinessException;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-11 上午8:17
 */
public class AccessException extends AbstractUncheckedBusinessException {
    public AccessException(ErrorCodeAndUserMessageEnum errorCodeAndUserMessageEnum, String errorMessage) {
        super(errorCodeAndUserMessageEnum, errorMessage);
    }
}
