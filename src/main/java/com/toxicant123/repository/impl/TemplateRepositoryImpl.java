package com.toxicant123.repository.impl;

import com.toxicant123.dao.TemplateDAO;
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
    private TemplateDAO templateDAO;
}
