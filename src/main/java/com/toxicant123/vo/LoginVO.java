package com.toxicant123.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-21 下午5:35
 */
@Data
@Accessors(chain = true)
public class LoginVO {

    private String token;
}
