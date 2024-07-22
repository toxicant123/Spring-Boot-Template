package com.toxicant123.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.toxicant123.param.UserParam;
import com.toxicant123.vo.UserVO;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 下午2:33
 */
public interface UserService {

    UserVO getUserById(Long id);

    Long getUserNameLength(Long id);

    IPage<UserVO> queryUserList(UserParam param);
}
