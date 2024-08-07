package com.toxicant123.bo;

import com.alibaba.fastjson2.util.DateUtils;
import com.toxicant123.util.LoginAesUtils;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-06 下午10:36
 */
@Data
@Accessors(chain = true)
public class UserLoginBO {

    private static final String USER_LOGIN_DETAIL_DELIMITER = ",";

    private static final String USER_ROLE_DELIMITER = "-";

    private Long userId;

    private Set<String> userRoles = new HashSet<>();

    private Date expireTime;

    public static UserLoginBO decode(String token) {

        var userInfoArr = LoginAesUtils.decrypt(token).split(USER_LOGIN_DETAIL_DELIMITER);

        return new UserLoginBO()
                .setUserId(Long.parseLong(userInfoArr[0]))
                .setUserRoles(Set.of(userInfoArr[1].split(USER_ROLE_DELIMITER)))
                .setExpireTime(DateUtils.parseDate(userInfoArr[2]));
    }

    public String encode() {
        return LoginAesUtils.encrypt(
                String.join(USER_LOGIN_DETAIL_DELIMITER,
                        userId.toString(),
                        String.join(USER_ROLE_DELIMITER, userRoles),
                        DateUtils.format(expireTime)
                ));
    }
}
