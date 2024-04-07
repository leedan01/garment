package com.garment.web.task;

import com.garment.web.domain.TbGarmentHistory;
import com.garment.web.enums.ImgCompressFlagEnums;
import com.garment.web.enums.ImgFlagEnums;
import com.garment.web.mapper.TbGarmentHistoryMapper;
import com.garment.web.util.ProjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Author leedan
 * @Description : 压缩下载图片
 * @Date 2023/10/26  14:30
 * @Version 1.0
 */
@EnableScheduling
@Component
@Configuration
public class CompressedImgTask {

    private static final Logger log = LoggerFactory.getLogger(CompressedImgTask.class);

    @Autowired
    private TbGarmentHistoryMapper tbGarmentHistoryMapper;

    /**
     *  压缩图片
     *
     *@Author leedan
     *@Description
     *@Date 2023/11/6
     *@param
     *@return void
     *@throws
     */
//    @Scheduled(initialDelay = 1000*10, fixedRate = 1000*60*60*4) //开始多少毫秒时候执行第一次  每隔多少毫秒执行一次
    public void setCurrencyPrice() throws Exception {
        int size = 1024 * 500;
        log.info("执行文件压缩");
        TbGarmentHistory tbGarmentHistory = new TbGarmentHistory();
        tbGarmentHistory.setUpdateFlag(ImgFlagEnums.YES.getCode());
        tbGarmentHistory.setCompressFlag(ImgCompressFlagEnums.NO.getCode());
        String lastPath = "/root/garment/uploadPath/upload/2023/10/15/";
        String baseUrl = "http://39.105.200.113:8083/profile/upload/2023/10/15/";
        List<TbGarmentHistory> list = tbGarmentHistoryMapper.selectTbGarmentHistoryList(tbGarmentHistory);
        list.forEach(v ->{
             String baseName =  v.getImgUrl();
             int index =  baseName.lastIndexOf("/")+1;
             String fileName = baseName.substring(index,baseName.length());
             String lastName  = lastPath + fileName;
             File file = new File(lastName);
             File targetFile = new File(lastName);
            try {
                ProjectUtils.compressImage(file,targetFile,size,300,300);
                String insertFileName = baseUrl+ProjectUtils.compressed+fileName;
                v.setCompressFlag(ImgCompressFlagEnums.YES.getCode());
                v.setCompressUrl(insertFileName);
                tbGarmentHistoryMapper.updateTbGarmentHistory(v);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }


}
