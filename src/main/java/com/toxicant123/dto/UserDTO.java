package com.toxicant123.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-22 下午7:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserDTO extends PageDTO {

    @Length(max = 128)
    private String name;

    private Short age;

    private Byte gender;

    private String email;
}
