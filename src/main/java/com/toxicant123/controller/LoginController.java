package com.toxicant123.controller;

import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.unchecked.AccessException;
import com.toxicant123.service.AccessCheckService;
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

    @Autowired
    private AccessCheckService accessCheckService;

    @PostMapping("/usernameAndPassword")
    public LoginVO usernameAndPassword(@RequestBody @Validated LoginParam param) {

        if (accessCheckService.checkAccessIsIllegal()) {
            throw new AccessException(ErrorCodeAndUserMessageEnum.B0501, "someone access LoginController.usernameAndPassword many times");
        }

        var userLoginBO = loginService.getUserLoginBOByUsernameAndPassword(param);

        return new LoginVO()
                .setToken(userLoginBO.encode());
    }
}
