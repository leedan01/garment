package com.garment.web.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author leedan
 * @Description : sd图生图传参
 * @Date 2023/11/9  9:58
 * @Version 1.0
 */
@Data
public class ImagineImage2ImageDTO {


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

    //插件
    private Object alwayson_scripts;

    private Double denoising_strength;

    private String sampler_name;

    //开启高清
    private boolean enable_hr;
    //高清修复算法
    private String hr_upscaler;

    //放大倍率
    private Integer hr_scale;


//    private String prompt;
//
//    private String negative_prompt;
//
//    private List<Object> styles;
//
//    private Integer seed = -1 ;
//
//    private Integer subseed = -1;
//
//    private Integer subseed_strength = 0;
//
//    private Integer seed_resize_from_h = -1;
//
//    private Integer seed_resize_from_w = -1;
//
//    private String sampler_name ;
//
//    private Integer batch_size = 1 ;
//
//    private Integer n_iter = 1 ;
//
//    private Integer steps = 50 ;
//
//    private Integer cfg_scale = 7 ;
//
//    private Integer width = 512 ;
//
//    private Integer height = 512 ;
//
//    private boolean restore_faces = true;
//
//    private boolean tiling = true;
//
//    private boolean do_not_save_samples = false;
//
//    private boolean do_not_save_grid = false;
//
//    private Integer eta = 0;
//
//    private Double denoising_strength = 0.75;
//
//    private Integer s_min_uncond = 0;
//
//    private Integer s_churn = 0;
//
//    private Integer s_tmax = 0;
//
//    private Integer s_tmin = 0;
//
//    private Integer s_noise = 0;
//
//    private Object override_settings;
//
//    private boolean override_settings_restore_afterwards = true;
//
//    private String refiner_checkpoint ;
//
//    private Integer refiner_switch_at = 0;
//
//    private boolean disable_extra_networks = false;
//
//    private Object comments;
//
//    private List<Object> init_images;
//
//    private Integer resize_mode = 0;
//
//    private Integer image_cfg_scale = 0;
//
//    private String mask;
//
//    private Integer mask_blur_x;
//
//    private Integer mask_blur_y;
//
//    private Integer mask_blur = 0;
//
//    private Integer inpainting_fill = 0;
//
//    private Boolean inpaint_full_res = true;
//
//    private Integer inpaint_full_res_padding = 0;
//
//    private Integer inpainting_mask_invert = 0;
//
//    private Integer initial_noise_multiplier = 0;
//
//    private String latent_mask;
//
//    private String sampler_index = "Euler";
//
//    private boolean include_init_images = false;
//
//    private String script_name ;
//
//    private List<Object> script_args;
//
//    private Boolean send_images =   true;
//
//    private boolean save_images = false;
//
//    private Object alwayson_scripts;



}
