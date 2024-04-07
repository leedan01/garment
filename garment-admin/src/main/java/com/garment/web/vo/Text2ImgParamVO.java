package com.garment.web.vo;

import com.garment.web.dto.SDModelDTO;
import lombok.Data;

import java.util.List;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/11/9  15:13
 * @Version 1.0
 */
@Data
public class Text2ImgParamVO {

    private Integer denoising_strength;

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

    private List<Object> init_images;

    private SDModelDTO override_settings;

    private List<Object> script_args;

    private String sampler_index;
}
