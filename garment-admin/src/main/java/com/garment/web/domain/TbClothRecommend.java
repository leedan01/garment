package com.garment.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.garment.common.annotation.Excel;
import com.garment.common.core.domain.BaseEntity;

/**
 * h5衣服尺寸推荐对象 tb_cloth_recommend
 *
 * @author ruoyi
 * @date 2023-12-18
 */
public class TbClothRecommend extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 展示衣服id */
    @Excel(name = "展示衣服id")
    private Long clothId;

    /** 尺码 */
    @Excel(name = "尺码")
    private String clothSize;

    /** 胸围 */
    @Excel(name = "胸围")
    private String bust;

    /** 衣长 */
    @Excel(name = "衣长")
    private String clothLength;

    /** 腰围 */
    @Excel(name = "腰围")
    private String waist;

    /** 裙长 */
    @Excel(name = "裙长")
    private String skirt;

    /** 推荐 */
    @Excel(name = "推荐")
    private String recommended;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setClothId(Long clothId)
    {
        this.clothId = clothId;
    }

    public Long getClothId()
    {
        return clothId;
    }
    public void setClothSize(String clothSize)
    {
        this.clothSize = clothSize;
    }

    public String getClothSize()
    {
        return clothSize;
    }
    public void setBust(String bust)
    {
        this.bust = bust;
    }

    public String getBust()
    {
        return bust;
    }
    public void setClothLength(String clothLength)
    {
        this.clothLength = clothLength;
    }

    public String getClothLength()
    {
        return clothLength;
    }
    public void setWaist(String waist)
    {
        this.waist = waist;
    }

    public String getWaist()
    {
        return waist;
    }
    public void setSkirt(String skirt)
    {
        this.skirt = skirt;
    }

    public String getSkirt()
    {
        return skirt;
    }
    public void setRecommended(String recommended)
    {
        this.recommended = recommended;
    }

    public String getRecommended()
    {
        return recommended;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("clothId", getClothId())
            .append("clothSize", getClothSize())
            .append("bust", getBust())
            .append("clothLength", getClothLength())
            .append("waist", getWaist())
            .append("skirt", getSkirt())
            .append("recommended", getRecommended())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
