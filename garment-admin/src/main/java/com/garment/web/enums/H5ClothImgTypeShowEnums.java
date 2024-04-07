package com.garment.web.enums;

/**
 * @Author leedan
 * @Description :  返回结果api枚举
 * @Date 2022/9/5  13:43
 * @Version 1.0
 */
public enum H5ClothImgTypeShowEnums {


    featured(1, "特色"),

    fabric(2,"面料"),
    real(3,"实物展示"),
    particulars(4,"细节"),
    cultural(101,"文创");



    private final Integer code;
    private final String desc;

    H5ClothImgTypeShowEnums(Integer code, String desc) {
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
