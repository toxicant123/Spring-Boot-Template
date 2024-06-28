package com.toxicant123.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.toxicant123.dto.AnimalDTO;
import com.toxicant123.exception.BusinessException;
import com.toxicant123.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-06-27 下午11:48
 */
@Slf4j
@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final Map<String, String> animalNameMap = new HashMap<>();

    {
        animalNameMap.put("Elephant", "大象");
        animalNameMap.put("Lion", "狮子");
        animalNameMap.put("Tiger", "老虎");
        animalNameMap.put("Giraffe", "长颈鹿");
        animalNameMap.put("Zebra", "斑马");
        animalNameMap.put("Monkey", "猴子");
        animalNameMap.put("Penguin", "企鹅");
        animalNameMap.put("Dolphin", "海豚");
        animalNameMap.put("Kangaroo", "袋鼠");
        animalNameMap.put("Koala", "考拉");
    }

    @GetMapping("/count")
    public Integer animalCount() {
        return 100;
    }

    @GetMapping("/names")
    public List<String> animalNames() {
        return animalNameMap.keySet().stream().toList();
    }

    @GetMapping("/nameSet")
    public Set<String> animalNameSet() {
        return animalNameMap.keySet();
    }

    @PostMapping
    public String translateAnimalName(@RequestBody AnimalDTO animal) {
        return animalNameMap.get(animal.getName());
    }

    @GetMapping("/rabbit")
    public ResponseData<String> rabbit() {
        return ResponseData.success("兔子");
    }

    @GetMapping("/object")
    public Object getObject() {
        return new Object();
    }

    @GetMapping("/jsonObject")
    public JSONObject getJsonObject() {
        return JSON.parseObject("{\"a\": 1, \"b\": \"2\", \"c\": true}");
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
            throw new BusinessException(500, "error3");
        }
        return "error3";
    }
}
