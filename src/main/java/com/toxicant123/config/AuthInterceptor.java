package com.toxicant123.config;

import com.toxicant123.annotation.RequireRole;
import com.toxicant123.bo.UserLoginBO;
import com.toxicant123.util.UserLoginUtils;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-09 下午1:10
 */
@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod hm) {
            var token = request.getHeader("auth");

            if (ObjectUtils.isEmpty(token)) {
                throw new AuthException();
            }

            var userLogin = UserLoginBO.decode(token);

            var annotation = hm.getMethod().getAnnotation(RequireRole.class);

            if (ObjectUtils.isEmpty(annotation)) {
                throw new AuthException();
            }

            boolean hasRole = false;
            for (var s : annotation.value()) {
                if (userLogin.getUserRoles().contains(s)) {
                    hasRole = true;
                    break;
                }
            }

            if (!hasRole) {
                throw new AuthException();
            }

            UserLoginUtils.setUserLoginBO(userLogin);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserLoginUtils.clearUserLoginBO();
    }
}
