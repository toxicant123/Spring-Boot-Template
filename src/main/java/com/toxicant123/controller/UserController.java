package com.toxicant123.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.toxicant123.annotation.RequireRole;
import com.toxicant123.constant.UserRoleConstant;
import com.toxicant123.param.UserParam;
import com.toxicant123.service.UserService;
import com.toxicant123.util.UserLoginUtils;
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
@RequireRole(UserRoleConstant.USER_ROLE_USER)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getCurrentUserInfo")
    public UserVO getCurrentUserInfo() {
        return getUserInfo(UserLoginUtils.getUserLoginBO().getUserId());
    }

    @GetMapping("/getUserInfo")
    @RequireRole(UserRoleConstant.USER_ROLE_ADMIN)
    public UserVO getUserInfo(@RequestParam("id") @NotNull(message = "id cannot be null") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/queryUserList")
    @RequireRole(UserRoleConstant.USER_ROLE_ADMIN)
    public IPage<UserVO> queryUserList(@RequestBody @Validated UserParam param) {
        return userService.queryUserList(param);
    }
}
