package com.toxicant123.param;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-27 下午11:18
 */
@Data
public class LoginParam {

    @NotNull(message = "username can not be null")
    private String username;

    @NotEmpty(message = "password can not be empty")
    private String password;
}
