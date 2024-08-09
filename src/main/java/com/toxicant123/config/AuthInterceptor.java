package com.toxicant123.config;

import com.toxicant123.annotation.RequireRole;
import com.toxicant123.bo.UserLoginBO;
import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.unchecked.AuthException;
import com.toxicant123.util.UserLoginUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-09 下午1:10
 */
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    private static final String AUTH_HEADER = "auth";
    ;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod hm) {
            var token = request.getHeader(AUTH_HEADER);

            if (ObjectUtils.isEmpty(token)) {
                throw new AuthException(ErrorCodeAndUserMessageEnum.A0251, "user login token is empty");
            }

            var userLogin = UserLoginBO.decode(token);

            if (new Date().compareTo(userLogin.getExpireTime()) >= 0) {
                throw new AuthException(ErrorCodeAndUserMessageEnum.A0230, "user login token expired");
            }

            var method = hm.getMethod();
            var annotation = method.getAnnotation(RequireRole.class);

            if (ObjectUtils.isEmpty(annotation)) {
                throw new AuthException(ErrorCodeAndUserMessageEnum.B0501, "required method-" + method.getName() + " didn't set required role");
            }

            boolean hasRole = false;
            for (var s : annotation.value()) {
                if (userLogin.getUserRoles().contains(s)) {
                    hasRole = true;
                    break;
                }
            }

            if (!hasRole) {
                throw new AuthException(ErrorCodeAndUserMessageEnum.A0301, "user didn't have required role");
            }

            UserLoginUtils.setUserLoginBO(userLogin);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserLoginUtils.clearUserLoginBO();
    }
}
