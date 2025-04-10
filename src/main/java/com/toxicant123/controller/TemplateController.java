package com.toxicant123.controller;

import com.toxicant123.annotation.RequireRole;
import com.toxicant123.constant.UserRoleConstant;
import com.toxicant123.dto.TemplateDTO;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/addTemplate")
    public TemplateDTO addTemplate(@RequestBody TemplateDTO templateDTO) {
        return null;
    }

    @PostMapping("/deleteTemplate")
    public TemplateDTO deleteTemplate(@RequestParam("id") Long templateId) {
        System.out.println(templateId);
        return null;
    }

    @PostMapping("/updateTemplate")
    public TemplateDTO updateTemplate(@RequestBody TemplateDTO templateDTO) {
        return null;
    }
}
