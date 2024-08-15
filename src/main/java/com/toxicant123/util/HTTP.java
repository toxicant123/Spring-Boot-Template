package com.toxicant123.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.unchecked.HttpException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-13 下午5:04
 */
@Slf4j
public class HTTP {

    private static final Duration timeout = Duration.ofSeconds(60);

    private static final HttpClient httpClient = HttpClient
            .newBuilder()
            .followRedirects(HttpClient.Redirect.NORMAL)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public static <T> T get(String url, Class<T> clazz) {
        return get(url, null, clazz);
    }

    public static <T> T get(String url, TypeReference<T> typeReference) {
        return get(url, null, typeReference);
    }

    public static <T> T get(String url, Map<String, String> params, Class<T> clazz) {
        return get(url, params, null, clazz);
    }

    public static <T> T get(String url, Map<String, String> params, TypeReference<T> typeReference) {
        return get(url, params, null, typeReference);
    }

    public static <T> T get(String url, Map<String, String> params, Map<String, String> headers, Class<T> clazz) {
        return request(HttpRequest.newBuilder().GET(), url, params, headers, str -> JSON.parseObject(str, clazz));
    }

    public static <T> T get(String url, Map<String, String> params, Map<String, String> headers, TypeReference<T> typeReference) {
        return request(HttpRequest.newBuilder().GET(), url, params, headers, str -> JSON.parseObject(str, typeReference));
    }

    public static <T> T post(String url, Class<T> clazz) {
        return post(url, null, clazz);
    }

    public static <T> T post(String url, TypeReference<T> typeReference) {
        return post(url, null, typeReference);
    }

    public static <T> T post(String url, Object body, Class<T> clazz) {
        return post(url, body, null, clazz);
    }

    public static <T> T post(String url, Object body, TypeReference<T> typeReference) {
        return post(url, body, null, typeReference);
    }

    public static <T> T post(String url, Object body, Map<String, String> params, Class<T> clazz) {
        return post(url, body, params, null, clazz);
    }

    public static <T> T post(String url, Object body, Map<String, String> params, TypeReference<T> typeReference) {
        return post(url, body, params, null, typeReference);
    }

    public static <T> T post(String url, Object body, Map<String, String> params, Map<String, String> headers, Class<T> clazz) {
        return request(HttpRequest.newBuilder().POST(getRequestBody(body)), url, params, headers, str -> JSON.parseObject(str, clazz));
    }

    public static <T> T post(String url, Object body, Map<String, String> params, Map<String, String> headers, TypeReference<T> typeReference) {
        return request(HttpRequest.newBuilder().POST(getRequestBody(body)), url, params, headers, str -> JSON.parseObject(str, typeReference));
    }

    private static HttpRequest.BodyPublisher getRequestBody(Object body) {
        return body != null
                ? HttpRequest.BodyPublishers.ofString(JSON.toJSONString(body), StandardCharsets.UTF_8)
                : HttpRequest.BodyPublishers.noBody();
    }

    private static <T> T request(HttpRequest.Builder builder, String url, Map<String, String> params, Map<String, String> headers, Function<String, T> function) {
        builder.timeout(timeout);

        if (ObjectUtils.isNotEmpty(params)) {
            url += params
                    .entrySet()
                    .stream()
                    .map(entry -> URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8)
                            + "="
                            + URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8))
                    .collect(Collectors.joining("&", "?", ""));
        }

        builder.uri(URI.create(url));

        if (ObjectUtils.isNotEmpty(headers)) {
            headers.forEach(builder::header);
        }

        var request = builder.build();

        var response = (HttpResponse<String>) null;

        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new HttpException(ErrorCodeAndUserMessageEnum.C0110, "http request error, url is " + url);
        }

        var statusCode = response.statusCode();

        if (statusCode >= HttpStatus.BAD_REQUEST.value()) {
            throw new HttpException(ErrorCodeAndUserMessageEnum.C0110, "http request url failed, url is " + url + ", response is " + response.body());
        }

        var responseBody = response.body();

        return function.apply(responseBody);
    }
}
