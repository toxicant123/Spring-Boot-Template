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
 * @create 2024-08-06 下午11:56
 */
@Slf4j
public class UsernameValidator implements ConstraintValidator<Password, String> {

    private static final Set<Character> USERNAME_SPECIAL_CHARACTER_SET = Stream
            .of(
                    SpecialCharEnum.SPACE,
                    SpecialCharEnum.HYPHEN,
                    SpecialCharEnum.UNDERSCORE
            )
            .map(SpecialCharEnum::getSymbol)
            .collect(Collectors.toUnmodifiableSet());

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        if (ObjectUtils.isEmpty(username)) {
            return false;
        }

        if (username.length() < 2 || username.length() > 20) {
            return false;
        }

        int conditionNum = 3;

        boolean numberCondition = true;
        boolean letterCondition = true;
        boolean specialCharCondition = true;

        for (char c : username.toCharArray()) {
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

            if (CharUtils.isAsciiAlpha(c)) {
                if (letterCondition) {
                    conditionNum--;
                    letterCondition = false;
                }
                continue;
            }

            if (USERNAME_SPECIAL_CHARACTER_SET.contains(c)) {
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
