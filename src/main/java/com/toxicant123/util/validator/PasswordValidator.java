package com.toxicant123.util.validator;

import com.toxicant123.annotation.Password;
import com.toxicant123.enums.SpecialCharEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-21 下午5:46
 */
@Slf4j
public class PasswordValidator implements ConstraintValidator<Password, String> {

    private static final Set<Character> PASSWORD_SPECIAL_CHARACTER_SET = Stream
            .of(
                    SpecialCharEnum.EXCLAMATION_MARK,
                    SpecialCharEnum.AT_SIGN,
                    SpecialCharEnum.NUMBER_SIGN
            )
            .map(SpecialCharEnum::getSymbol)
            .collect(Collectors.toUnmodifiableSet());

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (ObjectUtils.isEmpty(password)) {
            return false;
        }

        if (password.length() < 8 || password.length() > 20) {
            return false;
        }

        int conditionNum = 4;

        boolean numberCondition = true;
        boolean upperLetterCondition = true;
        boolean lowerLetterCondition = true;
        boolean specialCharCondition = true;

        for (char c : password.toCharArray()) {
            if (!CharUtils.isAscii(c)) {
                return false;
            }

            if (CharUtils.isAsciiNumeric(c)) {
                if (numberCondition) {
                    conditionNum--;
                    numberCondition = false;
                }
                continue;
            }

            if (CharUtils.isAsciiAlphaUpper(c)) {
                if (upperLetterCondition) {
                    conditionNum--;
                    upperLetterCondition = false;
                }
                continue;
            }

            if (CharUtils.isAsciiAlphaLower(c)) {
                if (lowerLetterCondition) {
                    conditionNum--;
                    lowerLetterCondition = false;
                }
                continue;
            }

            if (PASSWORD_SPECIAL_CHARACTER_SET.contains(c)) {
                if (specialCharCondition) {
                    conditionNum--;
                    specialCharCondition = false;
                }
                continue;
            }

            return false;
        }

        return conditionNum == 0;
    }
}
