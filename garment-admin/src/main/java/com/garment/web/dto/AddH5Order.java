package com.garment.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/12/19  14:13
 * @Version 1.0
 */
@Data
public class AddH5Order {

    /**姓名*/
    @ApiModelProperty(value = "姓名",required = true)
    private String name;

    /**联系电话*/
    @ApiModelProperty(value = "联系电话",required = true)
    private String phone;

    /**备注*/
    @ApiModelProperty(value = "备注",required = true)
    private String context;




}
