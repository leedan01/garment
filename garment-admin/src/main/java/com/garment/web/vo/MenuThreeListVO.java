package com.garment.web.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/11/8  14:58
 * @Version 1.0
 */
@Data
public class MenuThreeListVO {

    /**二级主键id*/
    private Long parentId;

    /**三级详情*/
    private List<MenuDetailVO> list;




}
