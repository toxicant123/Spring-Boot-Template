package com.toxicant123.repository.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.toxicant123.constant.ExistFlagConstant;
import com.toxicant123.dao.UserRoleDao;
import com.toxicant123.entity.UserRoleDO;
import com.toxicant123.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<String> queryUserRoleById(Long id) {
        return userRoleDao.selectList(new LambdaQueryWrapper<UserRoleDO>()
                        .select(UserRoleDO::getRole)
                        .eq(UserRoleDO::getUserId, id)
                        .eq(UserRoleDO::getExistFlag, ExistFlagConstant.EXIST_FLAG)
                )
                .stream()
                .map(UserRoleDO::getRole)
                .toList();
    }
}
