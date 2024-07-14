package com.toxicant123.service.convert.impl;

import com.toxicant123.dto.UserDTO;
import com.toxicant123.service.convert.UserConvertService;
import com.toxicant123.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 下午2:46
 */
@Slf4j
@Service
public class UserConvertServiceImpl implements UserConvertService {

    @Override
    public UserDTO convertUserVOToUserDTO(UserVO userVO) {
        var userDTO = new UserDTO();

        userDTO.setName(userVO.getName());
        userDTO.setAge(userVO.getAge());
        userDTO.setGender(userVO.getGender());
        userDTO.setEmail(userVO.getEmail());

        return userDTO;
    }
}
