package com.toxicant123.enums;

import lombok.Getter;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-06 下午11:59
 */
@Getter
public enum SpecialCharEnum {
    SPACE(' '),
    EXCLAMATION_MARK('!'),
    QUOTATION_MARK('"'),
    NUMBER_SIGN('#'),
    DOLLAR_SIGN('$'),
    PERCENT_SIGN('%'),
    AMPERSAND('&'),
    APOSTROPHE('\''),
    LEFT_PARENTHESIS('('),
    RIGHT_PARENTHESIS(')'),
    ASTERISK('*'),
    PLUS_SIGN('+'),
    COMMA(','),
    HYPHEN('-'),
    FULL_STOP('.'),
    SLASH('/'),
    COLON(':'),
    SEMICOLON(';'),
    LESS_THAN_SIGN('<'),
    EQUALS_SIGN('='),
    GREATER_THAN_SIGN('>'),
    QUESTION_MARK('?'),
    AT_SIGN('@'),
    LEFT_SQUARE_BRACKET('['),
    BACKSLASH('\\'),
    RIGHT_SQUARE_BRACKET(']'),
    CARET('^'),
    UNDERSCORE('_'),
    GRAVE_ACCENT('`'),
    LEFT_CURLY_BRACKET('{'),
    VERTICAL_LINE('|'),
    RIGHT_CURLY_BRACKET('}'),
    TILDE('~');

    private final char symbol;

    SpecialCharEnum(char symbol) {
        this.symbol = symbol;
    }
}
