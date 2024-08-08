package com.toxicant123.exception.unchecked;

import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.AbstractUncheckedBusinessException;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-08 下午8:35
 */
public class LoginException extends AbstractUncheckedBusinessException {

    public LoginException(ErrorCodeAndUserMessageEnum errorCodeAndUserMessageEnum, String errorMessage) {
        super(errorCodeAndUserMessageEnum, errorMessage);
    }
}

