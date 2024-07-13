package com.toxicant123.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-28 下午8:53
 */
public class MapUtils {

    public static <K, V> Map<K, V> of(K key, V value) {
        Map<K, V> map = new HashMap<>();
        map.put(key, value);
        return map;
    }

}
