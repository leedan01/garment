package com.garment.web.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @Author leedan
 * @Description : 前端文生图传参
 * @Date 2023/11/13  11:18
 * @Version 1.0
 */
@Data
public class Txt2ImgDTO {

    private Double denoising_strength;

    private String prompt;

    private String negative_prompt;

    private Integer seed;

    private Integer batch_size;

    private Integer n_iter;

    private Integer steps;

    private Integer cfg_scale;

    private Integer width;

    private Integer height;

    private Boolean restore_faces;

    private Boolean tiling;

    private SDModelDTO override_settings;

    private List<Object> script_args;

    private Object alwayson_scripts;

    private String sampler_index;

    private String sampler_name;

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
