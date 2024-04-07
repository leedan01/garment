package com.garment.web.enums;

/**
 * @Author leedan
 * @Description :  文创文本
 * @Date 2022/9/5  13:43
 * @Version 1.0
 */
public enum H5ShowCulturalEnums {


    CONTEXT("1", "文本"),

    INTRODUCE("2","介绍");


    private final String code;
    private final String desc;

    H5ShowCulturalEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
