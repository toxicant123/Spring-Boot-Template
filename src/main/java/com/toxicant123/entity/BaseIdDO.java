package com.toxicant123.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-25 上午8:17
 */
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class BaseIdDO extends BaseAuditDO {

    private Long id;
}
