package com.toxicant123.service.impl;

import com.toxicant123.service.AccessCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-08-11 上午8:15
 */
@Slf4j
@Service
public class AccessCheckServiceImpl implements AccessCheckService {

    @Override
    public boolean checkAccessIsIllegal() {
        return false;
    }
}
