package com.toxicant123.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.toxicant123.param.UserParam;
import com.toxicant123.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 上午11:31
 */
@Mapper
public interface UserDao extends BaseMapper<UserDO> {

    Long getUserNameLength(Long id);

    Page<UserDO> queryUserList(Page<UserDO> userPage, UserParam param);
}
