package com.toxicant123.service.convert.impl;

import com.toxicant123.entity.UserDO;
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
    public UserVO convertUserDOToUserVO(UserDO userDO) {
        var userVO = new UserVO();

        userVO.setName(userDO.getName());
        userVO.setAge(userDO.getAge());
        userVO.setGender(userDO.getGender());
        userVO.setEmail(userDO.getEmail());

        return userVO;
    }
}
