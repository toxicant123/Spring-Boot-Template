package com.toxicant123.controller;

import com.toxicant123.service.LoginService;
import com.toxicant123.vo.LoginVO;
import com.toxicant123.param.LoginParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-27 下午11:20
 */
@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/verify")
    public String verify() {
        return "success";
    }

    @PostMapping("/usernameAndPassword")
    public LoginVO login(@RequestBody @Validated LoginParam param) {

        var userLoginBO = loginService.getUserLoginBOByUsernameAndPassword(param);

        return new LoginVO()
                .setToken(userLoginBO.encode());
    }
}
