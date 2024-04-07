package com.garment.web.dto;

import lombok.Data;

/**
 * @Author leedan
 * @Description : 调用mj接口传参数
 * @Date 2023/10/31  14:53
 * @Version 1.0
 */
@Data
public class ImaginDTO{

    private String msg;

    private String ref;

    private String webhookOverride;

    private String ignorePrefilter;


}
