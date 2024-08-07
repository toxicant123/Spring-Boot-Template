package com.toxicant123.service.impl;

import com.toxicant123.bo.UserLoginBO;
import com.toxicant123.param.LoginParam;
import com.toxicant123.repository.UserAuthRepository;
import com.toxicant123.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-07 下午8:47
 */
@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Value("${login.token.expire-time}")
    private Integer loginTokenExpireTime;

    @Autowired
    private UserAuthRepository userAuthRepository;

    @Override
    public UserLoginBO getUserLoginBOByUsernameAndPassword(LoginParam param) {

        var userAuth = userAuthRepository.queryPasswordByUsername(param.getUsername());

        if (ObjectUtils.isEmpty(userAuth)) {

        }

        if (!StringUtils.equals(userAuth.getPassword(), param.getPassword())) {

        }

        var userLogin = new UserLoginBO();

        return null;
    }
}
