package com.toxicant123.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-27 下午11:19
 */
@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello";
    }
}
