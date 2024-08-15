package com.toxicant123.service;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-21 下午8:20
 */
public interface ValidateService {

    boolean isValid(Object o);

    boolean isValid(Object o, Class<?>... clazz);
}
