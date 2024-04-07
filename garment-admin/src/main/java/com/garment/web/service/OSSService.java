package com.garment.web.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * oss
 *
 * @author leedan
 * @date 2023-11-08
 */
public interface OSSService {

    /**
     * 上传商品
     *
     * @param file 文件
     * @return 结果
     */
    String upload(MultipartFile file);

    /**
     * 上传Base64图片
     *
     * @param image 图片
     * @return 结果
     */
    String upload(String image);
}
