package com.toxicant123.repository;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.toxicant123.entity.UserDO;
import com.toxicant123.param.UserParam;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 上午11:50
 */
public interface UserRepository {

    UserDO getUserById(Long id);

    Long getUserNameLength(Long id);

    Page<UserDO> queryUserList(UserParam param);
}
