package com.toxicant123.util;

import com.alibaba.fastjson2.JSON;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-13 下午5:04
 */
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

    public static <T> T get(String url, Map<String, String> params, Class<T> clazz) {
        return get(url, params, null, clazz);
    }

    public static <T> T get(String url, Map<String, String> params, Map<String, String> headers, Class<T> clazz) {
        return request(HttpRequest.newBuilder().GET(), url, params, headers, clazz);
    }

    public static <T> T post(String url, Class<T> clazz) {
        return post(url, null, clazz);
    }

    public static <T> T post(String url, Object body, Class<T> clazz) {
        return post(url, body, null, clazz);
    }

    public static <T> T post(String url, Object body, Map<String, String> params, Class<T> clazz) {
        return post(url, body, params, null, clazz);
    }


    public static <T> T post(String url, Object body, Map<String, String> params, Map<String, String> headers, Class<T> clazz) {
        var requestBody = body != null ?
                HttpRequest.BodyPublishers.ofString(JSON.toJSONString(body), StandardCharsets.UTF_8)
                : HttpRequest.BodyPublishers.noBody();
        return request(HttpRequest.newBuilder().POST(requestBody), url, params, headers, clazz);
    }

    public static <T> T request(HttpRequest.Builder builder, String url, Map<String, String> params, Map<String, String> headers, Class<T> clazz) {
        return null;
    }
}
