package com.garment.web.vo;

import com.garment.common.annotation.DataSource;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author leedan
 * @Description : 文创展示类
 * @Date 2023/12/20  10:11
 * @Version 1.0
 */
@Data
@Accessors(chain = true)
public class CultrualVO {

    @ApiModelProperty(value = "文创名称")
    private String name;

    /**描述*/
    @ApiModelProperty(value = "文本")
    private String context;

    /**图片1*/
    @ApiModelProperty(value = "图片1")
    private String imgOne;

    /**图片2*/
    @ApiModelProperty(value = "图片2")
    private String imgTwo;

    @ApiModelProperty(value = "内容列表")
    private List<CultrualContextVO>  contextList;

    @ApiModelProperty(value = "图片列表")
    private List<String> imgList;

    @ApiModelProperty(value = "介绍列表")
    private List<CultrualContextVO> introduceList;



}
