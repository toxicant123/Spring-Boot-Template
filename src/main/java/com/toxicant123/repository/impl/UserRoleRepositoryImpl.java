package com.toxicant123.repository.impl;

import com.toxicant123.dao.UserRoleDao;
import com.toxicant123.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-08 上午8:23
 */
@Repository
public class UserRoleRepositoryImpl implements UserRoleRepository {

    @Autowired
    private UserRoleDao userRoleDao;
}
