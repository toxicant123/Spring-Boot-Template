package com.toxicant123.annotation;

import com.toxicant123.util.validator.UsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-21 下午5:32
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UsernameValidator.class)
public @interface Username {

    String message() default "username is illegal";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
