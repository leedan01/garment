package com.garment.web.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/12/19  11:08
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class QueryClothDTO {

    @ApiModelProperty(value = "id",required = true)
    @NotNull(message = "id不能为空")
    private Long id;



}
