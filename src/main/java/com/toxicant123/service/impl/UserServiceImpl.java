package com.toxicant123.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.toxicant123.param.UserParam;
import com.toxicant123.repository.UserRepository;
import com.toxicant123.service.UserService;
import com.toxicant123.service.convert.UserConvertService;
import com.toxicant123.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 下午2:33
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConvertService userConvertService;

    @Override
    public UserDTO getUserById(Long id) {
        var userDO = userRepository.getUserById(id);

        return userConvertService.convertUserDOToUserDTO(userDO);
    }

    @Override
    public IPage<UserDTO> queryUserList(UserParam param) {
        return userRepository
                .queryUserList(param)
                .convert(userConvertService::convertUserDOToUserDTO);
    }
}
