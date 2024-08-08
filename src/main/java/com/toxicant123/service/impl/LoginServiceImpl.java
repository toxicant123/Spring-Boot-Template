package com.toxicant123.service.impl;

import com.toxicant123.bo.UserLoginBO;
import com.toxicant123.enums.ErrorCodeAndUserMessageEnum;
import com.toxicant123.exception.unchecked.LoginException;
import com.toxicant123.param.LoginParam;
import com.toxicant123.repository.UserAuthRepository;
import com.toxicant123.repository.UserRoleRepository;
import com.toxicant123.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;

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

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserLoginBO getUserLoginBOByUsernameAndPassword(LoginParam param) {

        var userAuth = userAuthRepository.queryPasswordByUsername(param.getUsername());

        if (ObjectUtils.isEmpty(userAuth)) {
            throw new LoginException(ErrorCodeAndUserMessageEnum.A0210, "username is not exist");
        }

        if (!StringUtils.equals(userAuth.getPassword(), param.getPassword())) {
            throw new LoginException(ErrorCodeAndUserMessageEnum.A0210, "username-" + param.getUsername() + "'s password is incorrect");
        }

        return new UserLoginBO()
                .setUserId(userAuth.getId())
                .setUserRoles(new HashSet<>(userRoleRepository.queryUserRoleById(userAuth.getId())))
                .setExpireTime(DateUtils.addMinutes(new Date(), loginTokenExpireTime));
    }
}
