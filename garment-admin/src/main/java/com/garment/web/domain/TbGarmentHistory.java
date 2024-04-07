package com.garment.web.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.garment.common.annotation.Excel;
import com.garment.common.core.domain.BaseEntity;

/**
 * history对象 tb_garment_history
 *
 * @author lee
 * @date 2023-10-24
 */
@Data
public class TbGarmentHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 文本描述 */
    @Excel(name = "文本描述")
    private String context;

    /** 转译文本 */
    @Excel(name = "转译文本")
    private String translateContext;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imgUrl;

    /**压缩图片地址*/
    private String compressUrl;

    /**是否下载1.未下载2.已下载*/
    private Integer updateFlag;

    /**压缩标识1.未压缩2.已压缩*/
    private Integer compressFlag;


}
