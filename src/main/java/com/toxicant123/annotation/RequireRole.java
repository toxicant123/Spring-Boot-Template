package com.toxicant123.annotation;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-09 下午12:54
 */
public @interface RequireRole {

    String[] value() default {};
}
