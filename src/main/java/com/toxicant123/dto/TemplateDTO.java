package com.toxicant123.dto;

import com.toxicant123.validation.AddTemplateValidation;
import com.toxicant123.validation.UpdateTemplateValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-10 08:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class TemplateDTO extends PageDTO {

    @Null(groups = AddTemplateValidation.class)
    @NotNull(groups = UpdateTemplateValidation.class)
    private Long id;

    @NotBlank(groups = {AddTemplateValidation.class, UpdateTemplateValidation.class})
    private String template;

    private String params;

    private Byte existFlag;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;
}
