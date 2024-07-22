package com.toxicant123.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.toxicant123.param.UserParam;
import com.toxicant123.service.UserService;
import com.toxicant123.vo.UserVO;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 下午2:31
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    public UserVO getUserById(@RequestParam("id") @NotNull(message = "id cannot be null") Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/userNameLength")
    public Long getUserNameLength(@RequestParam("id") @NotNull(message = "id cannot be null") Long id) {
        return userService.getUserNameLength(id);
    }

    @PostMapping("/queryUserList")
    public IPage<UserVO> queryUserList(@RequestBody @Validated UserParam param) {
        return userService.queryUserList(param);
    }
}
