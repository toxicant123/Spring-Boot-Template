package com.toxicant123.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONValidator;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.toxicant123.annotation.RequireRole;
import com.toxicant123.constant.UserRoleConstant;
import com.toxicant123.dto.TemplateDTO;
import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.checked.TemplateRenderException;
import com.toxicant123.exception.unchecked.TemplateException;
import com.toxicant123.service.TemplateService;
import com.toxicant123.validation.AddTemplateValidation;
import com.toxicant123.validation.UpdateTemplateValidation;
import jakarta.validation.ValidationException;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-10 08:24
 */
@Slf4j
@RestController
@RequestMapping("/template")
@RequireRole(UserRoleConstant.USER_ROLE_ADMIN)
public class TemplateController {

    @Autowired
    private TemplateService templateService;

    @PostMapping("/addTemplate")
    public Long addTemplate(@RequestBody @Validated(AddTemplateValidation.class) TemplateDTO templateDTO) {
        return templateService.addTemplate(templateDTO);
    }

    @PostMapping("/deleteTemplate")
    public Boolean deleteTemplate(@RequestParam("id") @NotNull(message = "templateId can't be null") Long templateId) {
        return templateService.deleteTemplate(templateId);
    }

    @PostMapping("/updateTemplate")
    public Boolean updateTemplate(@RequestBody @Validated(UpdateTemplateValidation.class) TemplateDTO templateDTO) {
        return templateService.updateTemplate(templateDTO);
    }

    @PostMapping("/queryTemplateList")
    public IPage<TemplateDTO> queryTemplateList(@RequestBody @Validated TemplateDTO templateDTO) {
        return templateService.queryTemplateList(templateDTO);
    }

    @PostMapping("/renderTemplate")
    public String renderTemplate(@RequestParam @NotNull(message = "templateId can't be null") Long templateId, @RequestBody(required = false) String body) {
        if (ObjectUtils.isNotEmpty(body)) {
            var validator = JSONValidator.from(body);
            if (!validator.validate()) {
                throw new ValidationException("request body must be json!");
            }
        } else {
            body = "{}";
        }

        var finalBody = body;
        try {
            return templateService.renderTemplate(templateId, t -> t.binding("body", JSON.parseObject(finalBody)));
        } catch (TemplateRenderException e) {
            throw new TemplateException(ErrorCodeAndUserMessageEnum.B0601, "render Template failed", e);
        }
    }
}
