package com.garment.web.enums;

/**
 * @Author leedan
 * @Description :  返回结果api枚举
 * @Date 2022/9/5  13:43
 * @Version 1.0
 */
public enum ImgCompressFlagEnums {


    NO(1, "未压缩"),

    YES(2,"已压缩");


    private final Integer code;
    private final String desc;

    ImgCompressFlagEnums(Integer code, String desc) {
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
