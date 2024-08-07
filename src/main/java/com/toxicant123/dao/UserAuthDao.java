package com.toxicant123.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.toxicant123.entity.UserAuthDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-07 下午8:53
 */
@Mapper
public interface UserAuthDao extends BaseMapper<UserAuthDO> {
}
