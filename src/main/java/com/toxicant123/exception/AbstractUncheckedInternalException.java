package com.toxicant123.exception;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-10 21:36
 */
public abstract class AbstractUncheckedInternalException extends RuntimeException {
    public AbstractUncheckedInternalException(String message) {
        super(message);
    }
}
