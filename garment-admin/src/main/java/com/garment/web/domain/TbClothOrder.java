package com.garment.web.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.garment.common.annotation.Excel;
import com.garment.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 tb_cloth_order
 *
 * @author ruoyi
 * @date 2023-12-19
 */
public class TbClothOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 相关描述 */
    @Excel(name = "相关描述")
    private String context;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setContext(String context)
    {
        this.context = context;
    }

    public String getContext()
    {
        return context;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("context", getContext())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
