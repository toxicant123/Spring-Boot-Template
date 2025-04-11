package com.toxicant123.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.toxicant123.constant.ExistFlagConstant;
import com.toxicant123.dao.TemplateDAO;
import com.toxicant123.dto.TemplateDTO;
import com.toxicant123.entity.TemplateDO;
import com.toxicant123.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2025-04-10 08:22
 */
@Repository
public class TemplateRepositoryImpl implements TemplateRepository {

    @Autowired
    private TemplateDAO templateDao;

    @Override
    public TemplateDO addTemplate(TemplateDO templateDO) {
        templateDao.insert(templateDO);
        return null;
    }

    @Override
    public Boolean deleteTemplate(Long templateId) {
        return null;
    }

    @Override
    public TemplateDTO updateTemplate(TemplateDO templateDO) {
        return null;
    }

    @Override
    public TemplateDO getTemplateById(Long templateId) {
        var queryWrapper = new LambdaQueryWrapper<TemplateDO>()
                .eq(TemplateDO::getId, templateId)
                .eq(TemplateDO::getExistFlag, ExistFlagConstant.EXIST_FLAG);
        return templateDao.selectOne(queryWrapper);
    }
}
