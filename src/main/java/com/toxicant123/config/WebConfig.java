package com.toxicant123.config;

import com.toxicant123.controller.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Set;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-28 下午9:49
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(converter -> converter instanceof StringHttpMessageConverter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        var unnecessaryAuthUrl = List.of(
                "/api/login/*",
                "/api/hello");

        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**") // 设置拦截器应用的路径模式
                .excludePathPatterns(unnecessaryAuthUrl); // 排除不需要拦截的路径
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        var apiSet = Set.of(
                AnimalController.class,
                ErrorController.class,
                HelloController.class,
                LoginController.class,
                ObjectController.class,
                UserController.class,
                VerifyController.class);

        configurer.addPathPrefix("/api", apiSet::contains);
    }
}
