package com.garment.web.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.garment.common.annotation.Excel;
import com.garment.common.core.domain.BaseEntity;

/**
 * h5文创演示类对象 tb_cultural
 *
 * @author ruoyi
 * @date 2023-12-20
 */
@Data
public class TbCultural extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /**描述*/
    private String context;

    /**图片1*/
    private String imgOne;

    /**图片2*/
    private String imgTwo;

}
