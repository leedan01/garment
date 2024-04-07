package com.garment.web.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/10/24  14:03
 * @Version 1.0
 */
@Data
public class AddHistoryDTO {

    /**图片地址*/
    @NotEmpty(message = "地址列表不能为空")
    private List<String>  urlList;

    /**文本内容*/
    @NotBlank(message = "文本内容")
    private String context;

    /**翻译后文本地址*/
    @NotBlank(message = "翻译后文本内容")
    private String translateContext;


}
