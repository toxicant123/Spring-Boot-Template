package com.toxicant123.repository;

import com.toxicant123.vo.UserVO;
import org.springframework.stereotype.Repository;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 上午11:50
 */
@Repository
public interface UserRepository {

    UserVO getUserById(Long id);
}
