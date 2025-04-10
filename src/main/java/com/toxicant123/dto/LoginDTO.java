package com.toxicant123.dto;

import com.toxicant123.annotation.Password;
import com.toxicant123.annotation.Username;
import lombok.Data;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-27 下午11:18
 */
@Data
public class LoginDTO {

    @Username
    private String username;

    @Password
    private String password;
}
