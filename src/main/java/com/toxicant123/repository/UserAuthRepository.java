package com.toxicant123.repository;

import com.toxicant123.entity.UserAuthDO;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-07 下午8:52
 */
public interface UserAuthRepository {

    UserAuthDO queryPasswordByUsername(String username);
}
