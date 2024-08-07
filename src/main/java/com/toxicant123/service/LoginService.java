package com.toxicant123.service;

import com.toxicant123.bo.UserLoginBO;
import com.toxicant123.param.LoginParam;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-07 下午8:47
 */
public interface LoginService {

    UserLoginBO getUserLoginBOByUsernameAndPassword(LoginParam param);
}
