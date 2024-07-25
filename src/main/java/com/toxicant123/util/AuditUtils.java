package com.toxicant123.util;

import com.toxicant123.constant.ExistFlagConstant;
import com.toxicant123.constant.UserIdConstant;
import com.toxicant123.entity.BaseAuditDO;

import java.util.Date;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-22 下午7:54
 */
public class AuditUtils {

    public static BaseAuditDO init(BaseAuditDO baseAuditDO) {
        return init(baseAuditDO, UserIdConstant.SYSTEM_ID);
    }

    public static BaseAuditDO init(BaseAuditDO baseAuditDO, Long creatorId) {
        baseAuditDO.setExistFlag(ExistFlagConstant.EXIST_FLAG);
        var now = new Date();
        baseAuditDO.setCreateTime(now);
        baseAuditDO.setUpdateTime(now);
        baseAuditDO.setCreateBy(creatorId);
        baseAuditDO.setUpdateBy(creatorId);
        return baseAuditDO;
    }

    public static BaseAuditDO update(BaseAuditDO baseAuditDO) {
        return update(baseAuditDO, UserIdConstant.SYSTEM_ID);
    }

    public static BaseAuditDO update(BaseAuditDO baseAuditDO, Long updaterId) {
        baseAuditDO.setUpdateTime(new Date());
        baseAuditDO.setUpdateBy(updaterId);
        return baseAuditDO;
    }

    public static BaseAuditDO delete(BaseAuditDO baseAuditDO) {
        return delete(baseAuditDO, UserIdConstant.SYSTEM_ID);
    }

    public static BaseAuditDO delete(BaseAuditDO baseAuditDO, Long deleter) {
        baseAuditDO.setExistFlag(ExistFlagConstant.NOT_EXIST_FLAG);
        return update(baseAuditDO, deleter);
    }
}
