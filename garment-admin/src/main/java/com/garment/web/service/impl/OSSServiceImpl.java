package com.garment.web.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.garment.web.service.OSSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Objects;
import java.util.UUID;
/**
 * h5衣服展示Service业务层处理
 *
 * @author ruoyi
 * @date 2023-12-18
 */
@Component
@Slf4j
public class OSSServiceImpl implements OSSService {

    @Value("${oss.bucket-name}")
    private String bucketName;

    @Value("${oss.end-point}")
    private String endPoint;

    @Autowired
    private AmazonS3 oss;

    @Override
    public String upload(MultipartFile file) {

        try {
            //获取原生文件名
            String originalFilename = file.getOriginalFilename();
            //JDK8的日期格式
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            //拼装OSS上存储的路径
            String folder = dft.format(time);
            String fileName = UUID.randomUUID().toString().replace("-", "");
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uploadFileName = "ai_show/" + folder + "/" + fileName + extension;

            String contentType = file.getContentType();
            // meta设置请求头
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType(contentType);

            PutObjectResult result = oss.putObject(bucketName, uploadFileName, file.getInputStream(), meta);
            //拼装返回路径
            if (Objects.isNull(result)) {
                return "";
            }
            return "https://" + endPoint + "/" + bucketName + "/" + uploadFileName;
        } catch (Exception e) {
            log.error("文件上传失败:{}", e.getMessage());
        }
        return "";
    }

    @Override
    public String upload(String image) {
        try {
            //转码
            byte[] decodedBytes = Base64.getDecoder().decode(image);

            // 将字节数组转换为InputStream对象
            InputStream inputStream = new ByteArrayInputStream(decodedBytes);

            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter dft = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            //拼装OSS上存储的路径
            String folder = dft.format(time);
            String fileName = UUID.randomUUID().toString().replace("-", "");
            String extension = ".jpg";

            //3 获取文件信息，为了上传
            // meta设置请求头
            ObjectMetadata meta = new ObjectMetadata();
            meta.setContentType("image/jpg");

            //在OSS上bucket下的文件名
            String uploadFileName = "user/" + folder + "/" + fileName + extension;


            PutObjectResult result = oss.putObject(bucketName, uploadFileName, inputStream, meta);
            //拼装返回路径
            if (Objects.isNull(result)) {
                return "";
            }
            return "https://" + endPoint + "/" + bucketName + "/" + uploadFileName;
        } catch (Exception e) {
            log.error("上传失败 -> e:{}", e.getMessage());
        }
        return null;
    }
}
