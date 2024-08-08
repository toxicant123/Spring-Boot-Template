package com.toxicant123.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-06 下午9:13
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractCheckedBusinessException extends Exception implements BusinessExceptionInterface {

    String errorCode;

    String errorMessage;

    String userMessage;
}
