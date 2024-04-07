package com.garment.web.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/11/8  14:29
 * @Version 1.0
 */
@Data
public class MenuVO {

    /**id*/
    private  Long id;

    /**标签*/
    private String label;

    /**标签值*/
    private String labelValue;

    /**类型*/
    private Integer type;

    /**父级id*/
    private Integer parentId;

    /**下级*/
    private List<MenuVO>  twoLevelList;



}
