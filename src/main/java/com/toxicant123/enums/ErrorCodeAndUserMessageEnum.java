package com.toxicant123.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-08 下午8:39
 */
@Getter
public enum ErrorCodeAndUserMessageEnum {

    //  用户端错误 - 用户登录异常 - 用户密码错误
    A0210("用户名或密码错误"),

    //  用户端错误 - 用户登录异常 - 用户登录已过期
    A0230("登录状态过期，请重新登录", HttpStatus.UNAUTHORIZED),

    // 用户端错误 - 用户登录异常 - 用户凭据异常
    A0250("登录凭据出错，请重新登录", HttpStatus.UNAUTHORIZED),

    // 用户端错误 - 用户登录异常 - 用户凭据异常 - 缺少凭据
    A0251("缺少登录凭据，请重新登录", HttpStatus.UNAUTHORIZED),

    // 用户端错误 - 访问权限异常 - 访问未授权
    A0301("暂无权限访问", HttpStatus.FORBIDDEN),

    // 用户端错误 - 用户请求参数错误
    A0400("请检查您的输入是否正确"),

    // 用户端错误 - 用户请求服务异常 - 请求次数超出限制
    A0501("访问频率过高，请稍后再试"),

    //  系统执行出错
    B0001("系统出错，请稍后再试"),

    // 系统执行出错 - 系统环境问题 - 必要信息丢失 - 加解密算法缺失
    B0411("登录异常，请稍后重试"),

    // 系统执行出错 - 系统配置问题 - 权限配置问题 - 缺少权限管控
    B0501("系统配置出错，请稍后再试"),

    // 调用第三方服务出错 - 中间件服务出错 - RPC 服务出错
    C0110("外部服务出错，请稍后再试");

    ErrorCodeAndUserMessageEnum(String userMessage) {
        this.userMessage = userMessage;
    }

    ErrorCodeAndUserMessageEnum(String userMessage, HttpStatus httpStatusCode) {
        this.userMessage = userMessage;
        this.httpStatusCode = httpStatusCode;
    }

    private final String userMessage;

    private HttpStatus httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
}
