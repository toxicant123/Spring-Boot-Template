package com.toxicant123.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-09 23:36
 */
@Data
@TableName("template")
@EqualsAndHashCode(callSuper = true)
public class TemplateDO extends BaseIdDO {

    private String template;

    private String params;
}
