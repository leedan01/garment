package com.garment.web.enums;

/**
 * @Author leedan
 * @Description :  返回结果api枚举
 * @Date 2022/9/5  13:43
 * @Version 1.0
 */
public enum H5ShowEnums {


    CLOTH("1", "衣服"),

    CULTURAL("2","文创");


    private final String code;
    private final String desc;

    H5ShowEnums(String code, String desc) {
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
