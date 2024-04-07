package com.garment.web.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.garment.web.service.OSSService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author leedan
 * @Description :
 * @Date 2024/1/3  14:41
 * @Version 1.0
 */
@Slf4j
public class AIUtil {


    /**
     * 获取img图片
     *
     *@Author leedan
     *@Description
     *@Date 2024/1/3
     *@param url
     *@param body
     *@param auth
     *@return java.lang.String
     *@throws
     */
    public static List<String> getImage(String url, String body, String auth) {
        List<String> list = new ArrayList<>();
        log.info("请求接口");
        OSSService ossService = SpringUtil.getBean(OSSService.class);
        String result = HttpRequest.post(url)
                .header("Authorization", "Basic " + auth)
                .body(body)
                .timeout(200000)
                .execute().body();

        JSONObject resultJson = JSON.parseObject(result);
        log.info("接口返回");
        if (!(resultJson.containsKey("images") && CollUtil.isNotEmpty(resultJson.getJSONArray("images")))) {
            log.info("生成失败");
            return null;
        }
        log.info("上传图片1");
        String images = ossService.upload(resultJson.getJSONArray("images").getString(0));
        list.add(images);
        String images1 = ossService.upload(resultJson.getJSONArray("images").getString(1));
        log.info("上传图片2");
        list.add(images1);
        log.info("AI图片 -> images:{}", images);
        return list;
    }

}
