package com.garment.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/12/20  10:17
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class CultrualContextVO {

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    private String context;

}
