package com.toxicant123.config;

import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.ExternalExceptionInterface;
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
        var data = (Object) null;
        var errorCode = "";
        var errorMessage = "";
        var userMessage = "";
        var uuid = UUID.randomUUID().toString();
        var httpStatus = (HttpStatus) null;

        if (ex instanceof ExternalExceptionInterface be) {
            log.error("uuid: {}, error detail: {}", uuid, be.getErrorMessage(), ex);

            errorCode = be.getErrorCode();
            errorMessage = be.getErrorMessage();
            userMessage = be.getUserMessage();
            httpStatus = be.getHttpStatus();
        } else if (ex instanceof MethodArgumentNotValidException mae) {
            log.error("uuid: {}, method argument not valid", uuid, ex);

            errorCode = ErrorCodeAndUserMessageEnum.A0400.name();
            errorMessage = "method argument not valid";
            var fieldError = mae.getFieldError();
            if (ObjectUtils.isNotEmpty(fieldError)) {
                errorMessage = fieldError.getField() + ": " + fieldError.getDefaultMessage();
            }
            userMessage = ErrorCodeAndUserMessageEnum.A0400.getUserMessage();
            httpStatus = HttpStatus.BAD_REQUEST;
        } else {
            log.error("uuid: {}, error happened", uuid, ex);

            errorCode = ErrorCodeAndUserMessageEnum.B0001.name();
            errorMessage = HttpStatus.INTERNAL_SERVER_ERROR.name();
            userMessage = ErrorCodeAndUserMessageEnum.B0001.getUserMessage();
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        EXCEPTION_STATUS_CODE.set(httpStatus);
        return ResponseData.fail(data, errorCode, errorMessage, userMessage, uuid);
    }
}
