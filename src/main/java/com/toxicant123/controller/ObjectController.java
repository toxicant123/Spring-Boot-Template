package com.toxicant123.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-28 下午9:26
 */
@Slf4j
@RestController
@RequestMapping("/object")
public class ObjectController {

    @GetMapping("/object")
    public Object getObject() {
        return new Object();
    }

    @GetMapping("/jsonObject")
    public JSONObject getJsonObject() {
        return JSON.parseObject("{\"a\": 1, \"b\": \"2\", \"c\": true}");
    }
}
