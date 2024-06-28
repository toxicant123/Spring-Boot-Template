package com.toxicant123.config;

import com.toxicant123.exception.BusinessException;
import com.toxicant123.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-27 下午11:30
 */
@Slf4j
@RestControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {

        if (String.class.equals(returnType.getParameterType())) {
            return false;
        }

        if (ResponseData.class.isAssignableFrom(returnType.getParameterType())) {
            return false;
        }

        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        return ResponseData.success(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseData<?> handleAllExceptions(Exception ex) {
        log.error("error happened", ex);

        if (ex instanceof BusinessException be) {
            return ResponseData.fail(null, be.getMessage(), be.getCode());
        } else if (ex instanceof MethodArgumentNotValidException mae) {
            var message = "method argument not valid";
            var fieldError = mae.getFieldError();
            if (ObjectUtils.isNotEmpty(fieldError)) {
                message = fieldError.getDefaultMessage();
            }
            return ResponseData.fail(null, message, 500);
        }

        return ResponseData.fail(null, ex.getMessage());
    }
}
