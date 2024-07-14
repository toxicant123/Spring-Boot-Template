package com.toxicant123.service;

import com.toxicant123.dto.UserDTO;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 下午2:33
 */
public interface UserService {

    UserDTO getUserById(Long id);
}
