package com.toxicant123.repository;

import java.util.List;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-08 上午8:23
 */
public interface UserRoleRepository {

    List<String>  queryUserRoleById(Long id);
}
