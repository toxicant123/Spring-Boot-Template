package com.toxicant123.service;

import com.toxicant123.dto.TemplateDTO;
import com.toxicant123.exception.checked.TemplateRenderException;
import org.beetl.core.Template;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-10 08:23
 */
public interface TemplateService {

    Long addTemplate(TemplateDTO templateDTO);

    Boolean deleteTemplate(Long templateId);

    Boolean updateTemplate(TemplateDTO templateDTO);

    Optional<String> renderTemplate(Long templateId, Consumer<Template> templateConsumer) throws TemplateRenderException;
}
