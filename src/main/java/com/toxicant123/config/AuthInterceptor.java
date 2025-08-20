package com.toxicant123.config;

import com.toxicant123.annotation.RequireRole;
import com.toxicant123.bo.UserLoginBO;
import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.unchecked.AuthException;
import com.toxicant123.util.UserLoginUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.Map;


/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-09 下午1:10
 */
@Component
public class AuthInterceptor implements HandlerInterceptor, HandshakeInterceptor {

    private static final String AUTH_HEADER = HttpHeaders.AUTHORIZATION;

    private static final String TOKEN_PARAM = "token";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var hm = (HandlerMethod) handler;
        var token = request.getHeader(AUTH_HEADER);

        if (ObjectUtils.isEmpty(token)) {
            throw new AuthException(ErrorCodeAndUserMessageEnum.A0251, "user login token is empty");
        }

        var userLogin = UserLoginBO.decode(token);

        if (new Date().compareTo(userLogin.getExpireTime()) > 0) {
            throw new AuthException(ErrorCodeAndUserMessageEnum.A0230, "user login token expired");
        }

        var roleArray = (String[]) null;
        var method = hm.getMethod();
        var methodAnnotation = method.getAnnotation(RequireRole.class);

        if (ObjectUtils.isEmpty(methodAnnotation)) {
            var classAnnotation = hm.getBeanType().getAnnotation(RequireRole.class);
            if (ObjectUtils.isNotEmpty(classAnnotation)) {
                roleArray = classAnnotation.value();
            }
        } else {
            roleArray = methodAnnotation.value();
        }

        if (ObjectUtils.isEmpty(roleArray)) {
            throw new AuthException(ErrorCodeAndUserMessageEnum.B0501, "required method-" + method.getName() + " didn't set required role");
        }

        boolean hasRole = false;
        for (var s : roleArray) {
            if (userLogin.getUserRoles().contains(s)) {
                hasRole = true;
                break;
            }
        }

        if (!hasRole) {
            throw new AuthException(ErrorCodeAndUserMessageEnum.A0301, "user didn't have required role");
        }

        UserLoginUtils.setUserLoginBO(userLogin);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserLoginUtils.clearUserLoginBO();
    }

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        var token = request.getHeaders().getFirst(AUTH_HEADER);

        if (ObjectUtils.isEmpty(token)) {
            token = UriComponentsBuilder
                    .fromUri(request.getURI())
                    .build()
                    .getQueryParams()
                    .getFirst(TOKEN_PARAM);
        }

        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
