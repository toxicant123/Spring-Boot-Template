package com.toxicant123.dto;

import com.toxicant123.validation.AddTemplateValidation;
import com.toxicant123.validation.UpdateTemplateValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-10 08:26
 */
@Data
public class TemplateDTO {

    @Null(groups = AddTemplateValidation.class)
    @NotNull(groups = UpdateTemplateValidation.class)
    private Long id;

    @NotBlank(groups = {AddTemplateValidation.class, UpdateTemplateValidation.class})
    private String template;

    private String params;
}
