package com.toxicant123.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-25 上午2:11
 */
@Data
public abstract class BaseAuditDO {

    private Byte existFlag;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
}
