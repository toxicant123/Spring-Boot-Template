package com.toxicant123.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-25 上午1:32
 */
@Data
@TableName("user_auth")
@EqualsAndHashCode(callSuper = true)
public class UserAuthDO extends BaseIdDO {

    private String username;

    private String password;

    private String phone;

    private String email;
}
