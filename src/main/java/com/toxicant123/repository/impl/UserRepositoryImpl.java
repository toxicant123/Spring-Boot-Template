package com.toxicant123.repository.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.toxicant123.constant.ExistFlagConstant;
import com.toxicant123.dao.UserDao;
import com.toxicant123.param.UserParam;
import com.toxicant123.repository.UserRepository;
import com.toxicant123.entity.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 上午11:51
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDO getUserById(Long id) {
        return userDao.selectOne(Wrappers
                .<UserDO>lambdaQuery()
                .select(UserDO::getName,
                        UserDO::getAge,
                        UserDO::getGender,
                        UserDO::getEmail)
                .eq(UserDO::getId, id)
                .eq(UserDO::getExistFlag, ExistFlagConstant.EXIST_FLAG));
    }

    @Override
    public Long getUserNameLength(Long id) {
        return userDao.getUserNameLength(id);
    }

    @Override
    public Page<UserDO> queryUserList(UserParam param) {
        return userDao.queryUserList(new Page<>(param.getCurPage(), param.getPageSize()), param);
    }
}
