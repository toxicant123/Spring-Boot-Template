package com.toxicant123.service.convert.impl;

import com.toxicant123.entity.UserDO;
import com.toxicant123.service.convert.UserConvertService;
import com.toxicant123.dto.UserDTO;
import org.springframework.stereotype.Service;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 下午2:46
 */
@Service
public class UserConvertServiceImpl implements UserConvertService {

    @Override
    public UserDTO convertUserDOToUserDTO(UserDO userDO) {
        var userDTO = new UserDTO();

        userDTO.setName(userDO.getName());
        userDTO.setAge(userDO.getAge());
        userDTO.setGender(userDO.getGender());
        userDTO.setEmail(userDO.getEmail());

        return userDTO;
    }
}
