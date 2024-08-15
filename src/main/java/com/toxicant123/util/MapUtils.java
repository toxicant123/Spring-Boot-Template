package com.toxicant123.util;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-28 下午8:53
 */
public class MapUtils {

    public static <T> Map<String, String> convertToStringStringMap(Map<String, T> sourceMap) {
        return sourceMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().toString()));
    }

    public static <T> Map<String, String> convertToStringStringMap(Map<String, T> sourceMap, Function<T, String> function) {
        return sourceMap
                .entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, ie -> function.apply(ie.getValue())));
    }
}
