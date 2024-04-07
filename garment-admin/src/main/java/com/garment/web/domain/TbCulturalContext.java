package com.garment.web.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.garment.common.annotation.Excel;
import com.garment.common.core.domain.BaseEntity;

/**
 * 文创内容文本介绍对象 tb_cultural_context
 *
 * @author ruoyi
 * @date 2023-12-20
 */
@Data
public class TbCulturalContext extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 文创id */
    @Excel(name = "文创id")
    private Long culturalId;

    private Long type;

    /** 内容标题 */
    @Excel(name = "内容标题")
    private String title;

    /** 内容介绍 */
    @Excel(name = "内容介绍")
    private String context;


}
