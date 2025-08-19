package com.toxicant123.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.toxicant123.annotation.RequireRole;
import com.toxicant123.constant.UserRoleConstant;
import com.toxicant123.dto.UserDTO;
import com.toxicant123.service.UserService;
import com.toxicant123.util.UserLoginUtils;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 下午2:31
 */
@RestController
@RequestMapping("/user")
@RequireRole(UserRoleConstant.USER_ROLE_USER)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getCurrentUserInfo")
    public UserDTO getCurrentUserInfo() {
        return getUserInfo(UserLoginUtils.getCurrentUserId());
    }

    @GetMapping("/getUserInfo")
    @RequireRole(UserRoleConstant.USER_ROLE_ADMIN)
    public UserDTO getUserInfo(@RequestParam("id") @NotNull(message = "id can't be null") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/queryUserList")
    @RequireRole(UserRoleConstant.USER_ROLE_ADMIN)
    public IPage<UserDTO> queryUserList(@RequestBody @Validated UserDTO userDTO) {
        return userService.queryUserList(userDTO);
    }
}
