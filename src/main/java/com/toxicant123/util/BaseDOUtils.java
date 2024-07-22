package com.toxicant123.util;

import com.toxicant123.constant.ExistFlagConstant;
import com.toxicant123.constant.UserIdConstant;
import com.toxicant123.entity.BaseDO;

import java.util.Date;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-22 下午7:54
 */
public class BaseDOUtils {

    public static BaseDO init(BaseDO baseDO) {
        return init(baseDO, UserIdConstant.SYSTEM_ID);
    }

    public static BaseDO init(BaseDO baseDO, Long creatorId) {
        baseDO.setExistFlag(ExistFlagConstant.EXIST_FLAG);
        var now = new Date();
        baseDO.setCreateTime(now);
        baseDO.setUpdateTime(now);
        baseDO.setCreateBy(creatorId);
        baseDO.setUpdateBy(creatorId);
        return baseDO;
    }

    public static BaseDO update(BaseDO baseDO) {
        return update(baseDO, UserIdConstant.SYSTEM_ID);
    }

    public static BaseDO update(BaseDO baseDO, Long updaterId) {
        baseDO.setUpdateTime(new Date());
        baseDO.setUpdateBy(updaterId);
        return baseDO;
    }

    public static BaseDO delete(BaseDO baseDO) {
        return delete(baseDO, UserIdConstant.SYSTEM_ID);
    }

    public static BaseDO delete(BaseDO baseDO, Long deleter) {
        baseDO.setExistFlag(ExistFlagConstant.NOT_EXIST_FLAG);
        return update(baseDO, deleter);
    }
}
