package com.toxicant123.config;

import com.toxicant123.bo.UserLoginBO;
import com.toxicant123.util.UserLoginUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.MemoryHandler;

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
        if (handler instanceof MemoryHandler mh) {
            var token = request.getHeader("auth");

            if (ObjectUtils.isEmpty(token)) {
                throw new RuntimeException();
            }

            var userLogin = UserLoginBO.decode(token);
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
