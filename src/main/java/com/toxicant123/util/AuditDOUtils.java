package com.toxicant123.util;

import com.toxicant123.constant.ExistFlagConstant;
import com.toxicant123.constant.UserIdConstant;
import com.toxicant123.entity.AuditDO;

import java.util.Date;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-22 下午7:54
 */
public class AuditDOUtils {

    public static AuditDO init(AuditDO auditDO) {
        return init(auditDO, UserIdConstant.SYSTEM_ID);
    }

    public static AuditDO init(AuditDO auditDO, Long creatorId) {
        auditDO.setExistFlag(ExistFlagConstant.EXIST_FLAG);
        var now = new Date();
        auditDO.setCreateTime(now);
        auditDO.setUpdateTime(now);
        auditDO.setCreateBy(creatorId);
        auditDO.setUpdateBy(creatorId);
        return auditDO;
    }

    public static AuditDO update(AuditDO auditDO) {
        return update(auditDO, UserIdConstant.SYSTEM_ID);
    }

    public static AuditDO update(AuditDO auditDO, Long updaterId) {
        auditDO.setUpdateTime(new Date());
        auditDO.setUpdateBy(updaterId);
        return auditDO;
    }

    public static AuditDO delete(AuditDO auditDO) {
        return delete(auditDO, UserIdConstant.SYSTEM_ID);
    }

    public static AuditDO delete(AuditDO auditDO, Long deleter) {
        auditDO.setExistFlag(ExistFlagConstant.NOT_EXIST_FLAG);
        return update(auditDO, deleter);
    }
}
