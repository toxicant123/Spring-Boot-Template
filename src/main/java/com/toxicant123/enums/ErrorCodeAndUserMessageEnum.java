package com.toxicant123.enums;

import lombok.Getter;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-08 下午8:39
 */
@Getter
public enum ErrorCodeAndUserMessageEnum {

    A0210("用户名或密码错误");

    ErrorCodeAndUserMessageEnum(String userMessage) {
        this.userMessage = userMessage;
    }

    private final String userMessage;
}
