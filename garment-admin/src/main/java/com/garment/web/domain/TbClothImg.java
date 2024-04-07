package com.garment.web.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.garment.common.annotation.Excel;
import com.garment.common.core.domain.BaseEntity;

/**
 * h5衣服展示图片对象 tb_cloth_img
 *
 * @author ruoyi
 * @date 2023-12-18
 */
@Data
public class TbClothImg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 衣服id */
    @Excel(name = "衣服id")
    private Long clothId;

    /** 类型（1.特色2.特写3.实物展示4.细节） */
    @Excel(name = "类型", readConverterExp = "1=.特色2.特写3.实物展示4.细节")
    private Long type;

    /** 文件地址 */
    @Excel(name = "文件地址")
    private String imgUrl;

   private Long flag;
}
