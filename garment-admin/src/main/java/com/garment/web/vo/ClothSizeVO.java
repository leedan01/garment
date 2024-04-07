package com.garment.web.vo;

import com.garment.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author leedan
 * @Description :  H5衣服尺码
 * @Date 2023/12/19  11:02
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class ClothSizeVO {


    /**尺码*/
    @ApiModelProperty(value = "尺码")
    private String clothSize;

    /** 胸围 */
    @ApiModelProperty(value = "胸围")
    private String bust;

    /** 衣长 */
    @ApiModelProperty(value = "衣长")
    private String clothLength;

    /** 腰围 */
    @ApiModelProperty(value = "腰围")
    private String waist;

    /** 裙长 */
    @ApiModelProperty(value = "裙长")
    private String skirt;

    /** 推荐 */
    @ApiModelProperty(value = "推荐")
    private String recommended;



}
