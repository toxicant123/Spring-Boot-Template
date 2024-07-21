package com.toxicant123.service.impl;

import com.toxicant123.service.ValidateService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

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
    private Validator validator;


    @Override
    public void validate(Object o) {
        var errors = validator.validateObject(o);

    }

    @Override
    public boolean isValidity(Object o) {
        return ObjectUtils.isEmpty(validator.validateObject(o).getAllErrors());
    }
}
