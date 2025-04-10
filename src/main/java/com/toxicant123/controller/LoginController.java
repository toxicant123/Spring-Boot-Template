package com.toxicant123.controller;

import com.toxicant123.dto.TokenDTO;
import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.unchecked.AccessException;
import com.toxicant123.service.AccessCheckService;
import com.toxicant123.service.LoginService;
import com.toxicant123.dto.LoginDTO;
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
    public TokenDTO usernameAndPassword(@RequestBody @Validated LoginDTO loginDTO) {

        if (accessCheckService.checkAccessIsIllegal()) {
            throw new AccessException(ErrorCodeAndUserMessageEnum.B0501, "someone access LoginController.usernameAndPassword many times");
        }

        var userLoginBO = loginService.getUserLoginBOByUsernameAndPassword(loginDTO);

        return new TokenDTO()
                .setToken(userLoginBO.encode());
    }
}
