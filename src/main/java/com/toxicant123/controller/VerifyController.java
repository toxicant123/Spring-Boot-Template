package com.toxicant123.controller;

import com.toxicant123.annotation.RequireRole;
import com.toxicant123.constant.UserRoleConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-10 下午5:07
 */
@Slf4j
@RestController
@RequestMapping("/verify")
public class VerifyController {

    @GetMapping
    @RequireRole(UserRoleConstant.USER_ROLE_USER)
    public String verify() {
        return "success";
    }
}
