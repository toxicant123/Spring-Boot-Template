package com.toxicant123.repository;

import com.toxicant123.dto.TemplateDTO;
import com.toxicant123.entity.TemplateDO;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-10 08:22
 */
public interface TemplateRepository {

    TemplateDO addTemplate(TemplateDO templateDO);

    Boolean deleteTemplate(Long templateId);

    TemplateDTO updateTemplate(TemplateDO templateDO);

    TemplateDO getTemplateById(Long templateId);
}
