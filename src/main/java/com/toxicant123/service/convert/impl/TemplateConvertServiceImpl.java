package com.toxicant123.service.convert.impl;

import com.toxicant123.dto.TemplateDTO;
import com.toxicant123.entity.TemplateDO;
import com.toxicant123.service.convert.TemplateConvertService;
import org.springframework.stereotype.Service;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-11 22:11
 */
@Service
public class TemplateConvertServiceImpl implements TemplateConvertService {

    @Override
    public TemplateDO convertTemplateDTOToTemplateDO(TemplateDTO templateDTO) {
        var templateDO = new TemplateDO();

        templateDO.setId(templateDTO.getId());
        templateDO.setTemplate(templateDTO.getTemplate());
        templateDO.setParams(templateDTO.getParams());

        return templateDO;
    }

    @Override
    public TemplateDTO convertTemplateDOToTemplateDTO(TemplateDO templateDO) {
        var templateDTO = new TemplateDTO();

        templateDTO.setId(templateDO.getId());
        templateDTO.setTemplate(templateDO.getTemplate());
        templateDTO.setParams(templateDO.getParams());
        templateDTO.setCreateBy(templateDO.getCreateBy());
        templateDTO.setCreateTime(templateDO.getCreateTime());
        templateDTO.setUpdateBy(templateDO.getUpdateBy());
        templateDTO.setUpdateTime(templateDO.getUpdateTime());

        return templateDTO;
    }
}
