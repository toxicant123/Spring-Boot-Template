package com.toxicant123.util;

import com.toxicant123.annotation.Password;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-21 下午5:46
 */
@Slf4j
public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (ObjectUtils.isEmpty(value)) {
            return false;
        }

        if (value.length() < 8 || value.length() > 20) {
            return false;
        }

        boolean hasNumber = false;
        boolean hasLetter = false;
        // ! @ #
        boolean hasSpecialChar = false;

        for (char c : value.toCharArray()) {
            if (c >= 48 && c <= 57) {
                hasNumber = true;
                continue;
            }

            if (c >= 65 && c <= 90) {
                hasLetter = true;
                continue;
            }

            if (c >= 97 && c <= 122) {
                hasLetter = true;
                continue;
            }

            if (c == 33 || c == 64 || c == 35) {
                hasSpecialChar = true;
            }
        }

        return hasNumber && hasLetter && hasSpecialChar;
    }
}
