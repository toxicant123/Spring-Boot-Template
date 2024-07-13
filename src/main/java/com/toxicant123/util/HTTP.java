package com.toxicant123.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.function.Function;

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
        return request(HttpRequest.newBuilder().GET(), url, null, params, headers, str -> JSON.parseObject(str, clazz));
    }

    public static <T> T get(String url, Map<String, String> params, Map<String, String> headers, TypeReference<T> typeReference) {
        return request(HttpRequest.newBuilder().GET(), url, null, params, headers, str -> JSON.parseObject(str, typeReference));
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
        return request(HttpRequest.newBuilder().POST(getRequestBody(body)), url, body, params, headers, str -> JSON.parseObject(str, clazz));
    }

    public static <T> T post(String url, Object body, Map<String, String> params, Map<String, String> headers, TypeReference<T> typeReference) {
        return request(HttpRequest.newBuilder().POST(getRequestBody(body)), url, body, params, headers, str -> JSON.parseObject(str, typeReference));
    }

    private static HttpRequest.BodyPublisher getRequestBody(Object body) {
        return body != null ?
                HttpRequest.BodyPublishers.ofString(JSON.toJSONString(body), StandardCharsets.UTF_8)
                : HttpRequest.BodyPublishers.noBody();
    }

    private static <T> T request(HttpRequest.Builder builder, String url, Object body, Map<String, String> params, Map<String, String> headers, Function<String, T> function) {
        builder.timeout(timeout);

        if (headers != null) {
            params.forEach(builder::header);
        }

        var request = builder.build();

        var result = (T) null;
        try {
            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            var responseBody = response.body();
            result = function.apply(responseBody);
        } catch (IOException | InterruptedException e) {
            log.error("send http request error, request url is {}, body is {}, params is {}, headers is {}",
                    url,
                    JSON.toJSONString(body),
                    params,
                    headers);

        }
        return result;
    }
}
