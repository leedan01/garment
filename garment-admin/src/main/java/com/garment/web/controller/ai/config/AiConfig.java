package com.garment.web.controller.ai.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/11/9  10:34
 * @Version 1.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "ai")
public class AiConfig {

    private String ip;

    private String userName;

    private String passWord;

    private String text2ImageInterface;

    private String image2ImageInterface;

    private String basePath;

    private String insertPath;

    private List<String> sdService;


}
