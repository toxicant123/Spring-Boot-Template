package com.toxicant123.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.toxicant123.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 上午11:31
 */
@Mapper
public interface UserDao extends BaseMapper<UserVO> {

    Long getUserNameLength(Long id);
}
