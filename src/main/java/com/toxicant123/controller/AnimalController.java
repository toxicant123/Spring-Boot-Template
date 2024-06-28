package com.toxicant123.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.toxicant123.util.ResponseData;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
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

    private Map<String, String> animalNameMap = new HashMap<>();

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
    public String translateAnimalName(@RequestBody String animalName) {
        return null;
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
}
