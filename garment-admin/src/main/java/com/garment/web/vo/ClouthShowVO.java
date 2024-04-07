package com.garment.web.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author leedan
 * @Description : H5衣服展示
 * @Date 2023/12/19  10:49
 * @Version 1.0
 */
@Data
public class ClouthShowVO {


    /**名称*/
    @ApiModelProperty(value = "名称")
    private String name;;

    /**面料*/
    @ApiModelProperty(value = "面料")
    private String fabric;

    /**面料*/
    @ApiModelProperty(value = "特色")
    private String characteristic;

    /**宝贝特点*/
    @ApiModelProperty(value = "宝贝特点")
    private String special;

    @ApiModelProperty(value = "细节")
    private String particulars;

    /**第一张图片*/
    @ApiModelProperty(value = "第一张图片")
    private String firstImg;

    /**全身图*/
    @ApiModelProperty(value = "全身图")
    private String wholeBodyImg;

    /**实物图*/
    @ApiModelProperty(value = "实物图")
    private String realImg;

    /**第一首诗标题*/
    @ApiModelProperty(value = "第一首诗标题")
    private String onePoenTitle;

    /**第一首诗内容*/
    @ApiModelProperty(value = "第一首诗内容")
    private String onePoen;

    /**第二首诗标题*/
    @ApiModelProperty(value = "第二首诗标题")
    private String twoPoemTitle;

    /**第二首诗内容*/
    @ApiModelProperty(value = "第二首诗内容")
    private String twoPoem;

    /**特色图列表*/
    @ApiModelProperty(value = "特色图列表")
    private List<String> featuredList;


    @ApiModelProperty(value = "面料图列表")
    private List<String> fabricList;

    /**实物展示列表*/
    @ApiModelProperty(value = "实物展示列表")
    private List<String> realList;

    /**细节展示图列表*/
    @ApiModelProperty(value = "细节展示图列表")
    private List<String> particularsList;

    /**尺寸列表*/
    @ApiModelProperty(value = "尺寸列表")
    private List<ClothSizeVO> sizeList;


}
