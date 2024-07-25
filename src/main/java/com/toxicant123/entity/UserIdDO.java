package com.toxicant123.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-25 上午8:18
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserIdDO extends AuditDO {

    @TableId
    private Long userId;
}
