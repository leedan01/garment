package com.garment.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.garment.common.annotation.Excel;
import com.garment.common.core.domain.BaseEntity;

/**
 * menu对象 tb_menu
 * 
 * @author leedan
 * @date 2023-11-08
 */
public class TbMenu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 标签 */
    @Excel(name = "标签")
    private String label;

    /** 标签英语 */
    @Excel(name = "标签英语")
    private String labelValue;

    /** 类型（1.一级菜单2.二级菜单3.三级菜单） */
    @Excel(name = "类型", readConverterExp = "1=.一级菜单2.二级菜单3.三级菜单")
    private Long type;

    /** 上级id */
    @Excel(name = "上级id")
    private Long parentId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLabel(String label) 
    {
        this.label = label;
    }

    public String getLabel() 
    {
        return label;
    }
    public void setLabelValue(String labelValue) 
    {
        this.labelValue = labelValue;
    }

    public String getLabelValue() 
    {
        return labelValue;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("label", getLabel())
            .append("labelValue", getLabelValue())
            .append("type", getType())
            .append("parentId", getParentId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
