package com.toxicant123.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.toxicant123.dto.TemplateDTO;
import com.toxicant123.exception.checked.TemplateRenderException;
import com.toxicant123.repository.TemplateRepository;
import com.toxicant123.service.TemplateService;
import com.toxicant123.service.convert.TemplateConvertService;
import com.toxicant123.util.AuditUtils;
import com.toxicant123.util.UserLoginUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-10 08:23
 */
@Slf4j
@Service
public class TemplateServiceImpl implements TemplateService {

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private GroupTemplate groupTemplate;

    @Autowired
    private TemplateConvertService templateConvertService;

    @Override
    public Long addTemplate(TemplateDTO templateDTO) {
        var templateDO = templateConvertService.convertTemplateDTOToTemplateDO(templateDTO);
        templateRepository.insertTemplate(templateDO);
        return templateDO.getId();
    }

    @Override
    public Boolean deleteTemplate(Long templateId) {
        var templateDO = templateRepository.getTemplateById(templateId);
        if (ObjectUtils.isEmpty(templateDO)) {
            throw new RuntimeException("该模板不存在或已被删除！模板ID：" + templateId);
        }

        AuditUtils.delete(templateDO, UserLoginUtils.getCurrentUserId());
        templateRepository.updateTemplateById(templateDO);
        return true;
    }

    @Override
    public Boolean updateTemplate(TemplateDTO templateDTO) {
        var templateDO = templateConvertService.convertTemplateDTOToTemplateDO(templateDTO);
        var templateId = templateDTO.getId();

        var templateOldDO = templateRepository.getTemplateById(templateDTO.getId());
        if (ObjectUtils.isEmpty(templateOldDO)) {
            throw new RuntimeException("该模板不存在或已被删除！模板ID：" + templateId);
        }

        templateRepository.updateTemplateById(templateDO);
        return true;
    }

    @Override
    public Optional<String> renderTemplate(Long templateId, Consumer<Template> templateConsumer) throws TemplateRenderException {
        var templateDO = templateRepository.getTemplateById(templateId);
        if (ObjectUtils.isEmpty(templateDO)) {
            throw new TemplateRenderException("can't find template, id is: " + templateId);
        }

        var paramsMap = (Map<String, String>) null;
        if (ObjectUtils.isNotEmpty(templateDO.getParams())) {
            paramsMap = JSON.parseObject(templateDO.getParams(), new TypeReference<>() {
            });
        }

        var template = groupTemplate.getTemplate(templateDO.getTemplate());
        if (ObjectUtils.isNotEmpty(paramsMap)) {
            template.binding("paramsMap", paramsMap);
        }
        templateConsumer.accept(template);

        return Optional.ofNullable(template.render());
    }
}
