package com.toxicant123.service.impl;

import com.toxicant123.service.ValidateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.SmartValidator;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-21 下午8:20
 */
@Slf4j
@Service
public class ValidateServiceImpl implements ValidateService {

    @Autowired
    private SmartValidator validator;

    @Override
    public boolean isValid(Object o) {
        var error = new BeanPropertyBindingResult(o, o.getClass().getName());
        validator.validate(o, error);
        return !error.hasErrors();
    }

    @Override
    public boolean isValid(Object o, Class<?>... clazz) {
        var error = new BeanPropertyBindingResult(o, o.getClass().getName());
        validator.validate(o, error, (Object) clazz);
        return false;
    }
}
