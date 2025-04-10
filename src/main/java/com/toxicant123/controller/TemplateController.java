package com.toxicant123.controller;

import com.toxicant123.annotation.RequireRole;
import com.toxicant123.constant.UserRoleConstant;
import com.toxicant123.dto.TemplateDTO;
import com.toxicant123.service.TemplateService;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
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
    public TemplateDTO addTemplate(@RequestBody @Validated TemplateDTO templateDTO) {
        return templateService.addTemplate(templateDTO);
    }

    @PostMapping("/deleteTemplate")
    public Boolean deleteTemplate(@RequestParam("id") @NotNull(message = "templateId can't be null") Long templateId) {
        return templateService.deleteTemplate(templateId);
    }

    @PostMapping("/updateTemplate")
    public TemplateDTO updateTemplate(@RequestBody TemplateDTO templateDTO) {
        return templateService.updateTemplate(templateDTO);
    }
}
