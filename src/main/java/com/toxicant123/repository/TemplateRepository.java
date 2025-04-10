package com.toxicant123.repository;

import com.toxicant123.entity.TemplateDO;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-10 08:22
 */
public interface TemplateRepository {

    TemplateDO getTemplateById(Long templateId);
}
