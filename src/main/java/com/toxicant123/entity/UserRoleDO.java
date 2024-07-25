package com.toxicant123.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-25 上午1:59
 */
@Data
@TableName("user_role")
@EqualsAndHashCode(callSuper = true)
public class UserRoleDO extends BaseDO {
}
