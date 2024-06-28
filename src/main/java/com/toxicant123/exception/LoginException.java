package com.toxicant123.exception;

import java.util.Map;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-28 下午7:51
 */
public class LoginException extends AbstractBusinessException {

    public LoginException(Integer code, String message, Map<String, Object> details) {
        super(code, message, details);
    }
}
