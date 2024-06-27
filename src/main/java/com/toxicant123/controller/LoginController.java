package com.toxicant123.controller;

import com.toxicant123.dto.LoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping
    public String login(@RequestBody @Validated LoginDTO dto) {
        return "success";
    }
}
