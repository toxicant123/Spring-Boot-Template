package com.toxicant123.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public TemplateDO insertTemplate(TemplateDO templateDO) {
        templateDao.insert(templateDO);
        return templateDO;
    }

    @Override
    public TemplateDO updateTemplateById(TemplateDO templateDO) {
        templateDao.updateById(templateDO);
        return templateDO;
    }

    @Override
    public TemplateDO getTemplateById(Long templateId) {
        var queryWrapper = new LambdaQueryWrapper<TemplateDO>()
                .eq(TemplateDO::getId, templateId)
                .eq(TemplateDO::getExistFlag, ExistFlagConstant.EXIST_FLAG);
        return templateDao.selectOne(queryWrapper);
    }

    @Override
    public IPage<TemplateDO> selectTemplateList(TemplateDTO templateDTO) {
        var page = new Page<TemplateDO>(templateDTO.getCurPage(), templateDTO.getPageSize());
        var queryWrapper = new LambdaQueryWrapper<TemplateDO>()
                .eq(TemplateDO::getExistFlag, ExistFlagConstant.EXIST_FLAG);
        templateDao.selectList(page, queryWrapper);
        return page;
    }
}
