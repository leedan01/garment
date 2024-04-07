package com.garment.web.enums;

/**
 * @Author leedan
 * @Description :  返回结果api枚举
 * @Date 2022/9/5  13:43
 * @Version 1.0
 */
public enum ImgFlagEnums {


    NO(1, "未下载"),

    YES(2,"无法解析新增una项目");


    private final Integer code;
    private final String desc;

    ImgFlagEnums(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
