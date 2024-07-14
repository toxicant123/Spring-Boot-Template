package com.toxicant123.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 下午12:33
 */
@Data
public class BaseVO {

    private Long id;

    private Byte existFlag;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;
}
