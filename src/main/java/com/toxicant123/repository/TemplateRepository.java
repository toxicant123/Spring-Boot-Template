package com.toxicant123.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.toxicant123.dto.TemplateDTO;
import com.toxicant123.entity.TemplateDO;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-10 08:22
 */
public interface TemplateRepository {

    TemplateDO insertTemplate(TemplateDO templateDO);

    TemplateDO updateTemplateById(TemplateDO templateDO);

    TemplateDO getTemplateById(Long templateId);

    IPage<TemplateDO> selectTemplateList(TemplateDTO templateDTO);
}
