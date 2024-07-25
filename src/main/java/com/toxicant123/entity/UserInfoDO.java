package com.toxicant123.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-25 上午1:34
 */
@Data
@TableName("user_info")
@EqualsAndHashCode(callSuper = true)
public class UserInfoDO extends UserIdDO {

    private String nickname;

    private Byte gender;

    private Short birthYear;

    private Byte birthMonth;

    private Byte birthDay;
}
