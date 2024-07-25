package com.toxicant123.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 下午12:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseDO extends AuditDO {

    private Long id;
}
