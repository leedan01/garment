package com.garment.web.vo;

import lombok.Data;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/10/31  14:09
 * @Version 1.0
 */
@Data
public class HistoryVO {

    private Long id;

    private String context;

    private String translateContext;

    private String imgUrl;

    /**压缩图片地址*/
    private String compressUrl;


}
