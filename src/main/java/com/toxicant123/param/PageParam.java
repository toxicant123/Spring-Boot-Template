package com.toxicant123.param;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

/**
 * @author toxicant123
 * @version 1.0
 * @Description
 * @create 2024-07-15 下午11:26
 */
@Data
public class PageParam {

    @Min(value = 1, message = "curPage can not be less than 1")
    private int curPage;

    @Min(value = 1, message = "pageSize can not be less than 1")
    @Max(value = 100, message = "pageSize can not be larger than 100")
    private int pageSize;
}
