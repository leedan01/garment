package com.garment.web.vo;

import com.garment.web.dto.ImagineText2ImageDTO;
import lombok.Data;

import java.util.List;

/**
 * @Author leedan
 * @Description : 文生图返回结果
 * @Date 2023/11/9  10:49
 * @Version 1.0
 */
@Data
public class ImageText2ImageVO {

    private List<String> images;

    private Text2ImgParamVO  parameters;

    private String info;

}
