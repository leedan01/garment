package com.garment.web.vo;

import io.swagger.models.auth.In;
import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/11/9  15:19
 * @Version 1.0
 */
@Data
public class Text2ImageInfoDTO {

    private String prompt;

    private List<String> all_prompts;

    private String negative_prompt;

    private List<Object> all_negative_prompts;

    private Integer seed;

    private List<Integer> all_seeds;

    private Integer subseed;

    private List<Integer> all_subseeds;

    private Integer subseed_strength;
    private Integer width;
    private Integer height;

    private String sampler_name;

    private Double cfg_scale;

    private Integer steps;

    private Integer batch_size;

    private Boolean restore_faces;

    private String face_restoration_model;

    private String sd_model_name;

    private String sd_model_hash;

    private String sd_vae_name;

    private String sd_vae_hash;

    private Integer seed_resize_from_w;

    private Integer seed_resize_from_h;

    private Double denoising_strength;

    private Object extra_generation_params;

    private Integer index_of_first_image;

    private List<Object> infotexts;

    private List<Object> styles;

    private String job_timestamp;

    private Integer clip_skip;

    private Boolean is_using_inpainting_conditioning;
















}
