package com.hxf.demo.demo.designpatterns.strategy.web;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/6/22 16:38
 */
@Data
@ApiModel
public class OfflineCouponReq {

    @ApiModelProperty("领券中心id")
    @Min(value = 1, message = "领券中心id不能小于1")
    @Max(value = Long.MAX_VALUE, message = "领券id不能大于" + Long.MAX_VALUE)
    private long id;


    @ApiModelProperty(hidden = true)
    private long userId;

    @ApiModelProperty("是否全部")
    private boolean isAll;
}
