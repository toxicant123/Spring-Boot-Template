package com.toxicant123.repository.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.toxicant123.constant.ExistFlagConstant;
import com.toxicant123.dao.UserDao;
import com.toxicant123.repository.UserRepository;
import com.toxicant123.vo.UserVO;
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
    public UserVO getUserById(Long id) {
        return userDao.selectOne(Wrappers
                .<UserVO>lambdaQuery()
                .select(UserVO::getName,
                        UserVO::getAge,
                        UserVO::getGender,
                        UserVO::getEmail)
                .eq(UserVO::getId, id)
                .eq(UserVO::getExistFlag, ExistFlagConstant.EXIST_FLAG));
    }
}
