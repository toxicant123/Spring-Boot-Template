package com.toxicant123.config;

import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.BusinessExceptionInterface;
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

    private static final ThreadLocal<HttpStatus> EXCEPTION_STATUS_CODE = new ThreadLocal<>();

    @Override
    public boolean supports(MethodParameter returnType,
                            Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {

        if (body instanceof ResponseData<?> rd) {
            response.setStatusCode(EXCEPTION_STATUS_CODE.get());
            EXCEPTION_STATUS_CODE.remove();
            return rd;
        }

        return ResponseData.success(body);
    }

    @ExceptionHandler(Exception.class)
    public ResponseData<?> handleAllExceptions(Exception ex) {
        var uuid = UUID.randomUUID().toString();
        EXCEPTION_STATUS_CODE.set(HttpStatus.INTERNAL_SERVER_ERROR);

        if (ex instanceof BusinessExceptionInterface be) {
            EXCEPTION_STATUS_CODE.set(be.getHttpStatus());
            log.error("uuid: {}, error detail: {}", uuid, be.getErrorMessage(), ex);

            return ResponseData.fail(null, be.getErrorCode(), be.getErrorMessage(), be.getUserMessage(), uuid);
        } else if (ex instanceof MethodArgumentNotValidException mae) {
            log.error("uuid: {}, method argument not valid", uuid, ex);

            var message = "method argument not valid";
            var fieldError = mae.getFieldError();
            if (ObjectUtils.isNotEmpty(fieldError)) {
                message = fieldError.getField() + ": " + fieldError.getDefaultMessage();
            }
            return ResponseData.fail(null, ErrorCodeAndUserMessageEnum.A0400.name(), message, ErrorCodeAndUserMessageEnum.A0400.getUserMessage(), uuid);
        } else {
            log.error("uuid: {}, error happened", uuid, ex);

            return ResponseData.fail(null,
                    ErrorCodeAndUserMessageEnum.B0001.name(),
                    HttpStatus.INTERNAL_SERVER_ERROR.name(),
                    ErrorCodeAndUserMessageEnum.B0001.getUserMessage(),
                    uuid);
        }
    }
}
