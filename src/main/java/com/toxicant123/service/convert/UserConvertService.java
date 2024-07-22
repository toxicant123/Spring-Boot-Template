package com.toxicant123.service.convert;

import com.toxicant123.entity.UserDO;
import com.toxicant123.vo.UserVO;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 下午2:46
 */
public interface UserConvertService {

    UserVO convertUserDOToUserVO(UserDO userVO);
}
