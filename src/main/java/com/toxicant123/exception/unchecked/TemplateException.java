package com.toxicant123.exception.unchecked;

import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.AbstractUncheckedExternalException;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-11 21:46
 */
public class TemplateException extends AbstractUncheckedExternalException {
    public TemplateException(ErrorCodeAndUserMessageEnum errorCodeAndUserMessageEnum, String errorMessage, String userMessage) {
        super(errorCodeAndUserMessageEnum, errorMessage, userMessage);
    }

    public TemplateException(ErrorCodeAndUserMessageEnum errorCodeAndUserMessageEnum, String errorMessage, Throwable cause) {
        super(errorCodeAndUserMessageEnum, errorMessage, cause);
    }

    public TemplateException(ErrorCodeAndUserMessageEnum errorCodeAndUserMessageEnum, String errorMessage) {
        super(errorCodeAndUserMessageEnum, errorMessage);
    }
}
