package com.toxicant123.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 下午12:33
 */
@Data
public class BaseDO {

    private Long id;

    private Byte existFlag;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
}
