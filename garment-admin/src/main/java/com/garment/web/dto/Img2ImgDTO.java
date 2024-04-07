package com.garment.web.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author leedan
 * @Description :  前端图生图传参
 * @Date 2023/11/13  11:25
 * @Version 1.0
 */
@Data
public class Img2ImgDTO {

    private List<Object> init_images;

    private String prompt;

    private String negative_prompt;

    private Integer batch_size;

    private Integer steps;

    private Integer seed;

    private Integer width;

    private Integer height;

    private boolean restore_faces ;

    private Object override_settings;

    private List<Object> script_args;

    private Object alwayson_scripts;

    private String sampler_name;

    private Double denoising_strength ;

    //高清修复开启
    private boolean enable_hr;

    //高清修复算法
    private String hr_upscaler;

    //放大倍率
    private Integer hr_scale;

    //    /**文本内容*/
//    @NotBlank(message = "文本内容")
    private String context;

    /**翻译后文本地址*/
//    @NotBlank(message = "翻译后文本内容")
    private String translateContext;

}
