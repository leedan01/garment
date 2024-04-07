package com.garment.web.dto;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * @Author leedan
 * @Description : sd文生图传参
 * @Date 2023/11/9  9:32
 * @Version 1.0
 */
@Data
public class ImagineText2ImageDTO {

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

    private String sampler_index;

    private Object alwayson_scripts;

    private String sampler_name;

    //高清修复开启
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
//    private Integer denoising_strength = 0;
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
//    private boolean enable_hr = false;
//
//    private Integer firstphase_width = 0;
//
//    private Integer firstphase_height = 0;
//
//    private Integer hr_scale = 2;
//
//    private String hr_upscaler ;
//
//    private Integer hr_second_pass_steps = 0 ;
//
//    private Integer hr_resize_x = 0 ;
//
//    private Integer hr_resize_y = 0 ;
//
//    private String hr_checkpoint_name  ;
//
//    private String hr_sampler_name  ;
//
//    private String hr_prompt  ;
//
//    private String sampler_index = "Euler"  ;
//
//    private String script_name = "Euler"  ;
//
//    private List<Object> script_args  ;
//
//    private boolean send_images = true  ;
//
//    private boolean save_images = false  ;
//
//    private Object alwayson_scripts;

}
