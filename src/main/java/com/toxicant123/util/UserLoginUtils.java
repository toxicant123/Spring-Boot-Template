package com.toxicant123.util;

import com.toxicant123.bo.UserLoginBO;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-06 下午11:50
 */
public class UserLoginUtils {

    private static final ThreadLocal<UserLoginBO> USER_LOGIN_BO_THREAD_LOCAL = new ThreadLocal<>();

    public static void setUserLoginBO(UserLoginBO userLoginBO) {
        USER_LOGIN_BO_THREAD_LOCAL.set(userLoginBO);
    }

    public static UserLoginBO getUserLoginBO() {
        return USER_LOGIN_BO_THREAD_LOCAL.get();
    }
}
