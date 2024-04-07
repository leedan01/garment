package com.garment.web.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.garment.common.annotation.Excel;
import com.garment.common.core.domain.BaseEntity;

/**
 * h5衣服展示对象 tb_cloth
 *
 * @author ruoyi
 * @date 2023-12-18
 */
@Data
public class TbCloth extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 面料 */
    @Excel(name = "面料")
    private String fabric;

    /**特色*/
    private String characteristic;

    /**细节*/
    private String particulars;

    /**特点*/
    private String special;

    /** 头图 */
    @Excel(name = "头图")
    private String firstImg;

    /** 全身图 */
    @Excel(name = "全身图")
    private String wholeBodyImg;

    /** 实物图 */
    @Excel(name = "实物图")
    private String realImg;

    /** 第一首诗标题 */
    @Excel(name = "第一首诗标题")
    private String onePoenTitle;

    /** 第一首诗 */
    @Excel(name = "第一首诗")
    private String onePoen;

    /** 第二首诗标题 */
    @Excel(name = "第二首诗标题")
    private String twoPoemTitle;

    /** 第二首诗 */
    @Excel(name = "第二首诗")
    private String twoPoem;


}
