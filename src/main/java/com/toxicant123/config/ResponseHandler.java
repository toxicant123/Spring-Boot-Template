package com.toxicant123.config;

import com.alibaba.fastjson2.JSON;
import com.toxicant123.constant.BusinessExceptionConstant;
import com.toxicant123.exception.BusinessException;
import com.toxicant123.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.UUID;

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
        var uuid = UUID.randomUUID().toString();

        if (ex instanceof BusinessException be) {
            log.error("uuid: {}, error detail: {}", uuid, JSON.toJSONString(be.getDetails()), ex);

            return ResponseData.fail(null, be.getMessage(), be.getCode(), uuid);
        } else if (ex instanceof MethodArgumentNotValidException mae) {
            log.error("uuid: {}, method argument not valid", uuid, ex);

            var message = "method argument not valid";
            var fieldError = mae.getFieldError();
            if (ObjectUtils.isNotEmpty(fieldError)) {
                message = fieldError.getDefaultMessage();
            }
            return ResponseData.fail(null, message, BusinessExceptionConstant.FIELD_NOT_VALID, uuid);
        } else {
            log.error("uuid: {}, error happened", uuid, ex);

            return ResponseData.fail(null, HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR.value(), uuid);
        }
    }
}
