package com.toxicant123.exception.checked;

import com.toxicant123.exception.AbstractCheckedInternalException;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-10 21:01
 */
public class TemplateRenderException extends AbstractCheckedInternalException {
    public TemplateRenderException(String errorMessage) {
        super(errorMessage);
    }
}
