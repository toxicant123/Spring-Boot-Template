package com.toxicant123.service.convert;

import com.toxicant123.dto.TemplateDTO;
import com.toxicant123.entity.TemplateDO;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-11 22:11
 */
public interface TemplateConvertService {

    TemplateDO convertTemplateDTOToTemplateDO(TemplateDTO templateDTO);
}
