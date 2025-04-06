package com.toxicant123.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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

    @GetMapping("/error1")
    public String error1() {
        int i = 1 / 0;
        return "error1";
    }

    @GetMapping("/error2")
    public String error2() {
        String a = null;
        a.substring(1);
        return "error2";
    }

    @GetMapping("/error3")
    public String error3() {
        if (1 > Math.random()) {
        }
        return "error3";
    }

    @GetMapping("/error4")
    public String error4() throws FileNotFoundException {
        var file = new File("D:\\abcdefg.txt");
        var bufferedReader = new BufferedReader(new FileReader(file));
        return "error3";
    }

    @GetMapping("/object")
    public Object getObject() {
        return new Object();
    }

    @GetMapping("/jsonObject")
    public JSONObject getJsonObject() {
        return JSON.parseObject("{\"a\": 1, \"b\": \"2\", \"c\": true}");
    }
}
