package com.toxicant123.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.toxicant123.dao.UserAuthDao;
import com.toxicant123.entity.UserAuthDO;
import com.toxicant123.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-07 下午8:52
 */
@Repository
public class UserAuthRepositoryImpl implements UserAuthRepository {

    @Autowired
    private UserAuthDao userAuthDao;

    @Override
    public UserAuthDO queryPasswordByUsername(String username) {
        return userAuthDao.selectOne(new LambdaQueryWrapper<UserAuthDO>()
                .select(UserAuthDO::getId)
                .select(UserAuthDO::getPassword)
                .eq(UserAuthDO::getUsername, username));
    }
}
