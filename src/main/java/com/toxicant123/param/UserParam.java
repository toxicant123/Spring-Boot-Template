package com.toxicant123.param;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-15 下午11:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserParam extends PageParam {

    private Byte minGender;
}
