package com.garment.web.vo;

import lombok.Data;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/11/8  14:31
 * @Version 1.0
 */
@Data
public class MenuDetailVO {

    private  Long id;

    private String label;

    private String labelVal;

    private Integer type;

    private Integer parentId;

}
