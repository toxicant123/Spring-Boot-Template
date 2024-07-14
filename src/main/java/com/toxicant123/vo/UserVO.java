package com.toxicant123.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-14 上午11:32
 */
@Data
@TableName("user")
@EqualsAndHashCode(callSuper = true)
public class UserVO extends BaseVO{

    private String name;

    private Short age;

    private Byte gender;

    private String email;
}
