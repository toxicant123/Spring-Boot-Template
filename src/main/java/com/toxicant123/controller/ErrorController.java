package com.toxicant123.controller;

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
 * @create 2024-06-28 下午9:25
 */
@Slf4j
@RestController
@RequestMapping("/error")
public class ErrorController {

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
}
