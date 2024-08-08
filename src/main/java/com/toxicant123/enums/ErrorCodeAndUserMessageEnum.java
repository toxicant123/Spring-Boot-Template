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

    A0210("用户名或密码错误"),
    A0400("请检查您的输入是否正确"),
    B0001("系统出错，请稍后再试"),
    C0110("外部服务出错，请稍后再试");

    ErrorCodeAndUserMessageEnum(String userMessage) {
        this.userMessage = userMessage;
    }

    private final String userMessage;
}
