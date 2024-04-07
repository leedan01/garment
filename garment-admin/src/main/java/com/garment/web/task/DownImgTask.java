package com.garment.web.task;

import com.garment.web.domain.TbGarmentHistory;
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

import java.util.List;

/**
 * @Author leedan
 * @Description : 下载mj图片
 * @Date 2023/10/26  14:30
 * @Version 1.0
 */
@EnableScheduling
@Component
@Configuration
public class DownImgTask {

    private static final Logger log = LoggerFactory.getLogger(DownImgTask.class);

    @Autowired
    private TbGarmentHistoryMapper tbGarmentHistoryMapper;


//    @Scheduled(initialDelay = 1000*10, fixedRate = 1000*60*60*4) //开始多少毫秒时候执行第一次  每隔多少毫秒执行一次
    public void setCurrencyPrice() throws Exception {
        log.info("执行文件下载");
        TbGarmentHistory tbGarmentHistory = new TbGarmentHistory();
        tbGarmentHistory.setUpdateFlag(ImgFlagEnums.NO.getCode());
        String lastPath = "/root/garment/uploadPath/upload/2023/10/15/";
        String baseUrl = "http://39.105.200.113:8083/profile/upload/2023/10/15/";
        List<TbGarmentHistory> list = tbGarmentHistoryMapper.selectTbGarmentHistoryList(tbGarmentHistory);
        list.forEach(v ->{
            String imgUrl = v.getImgUrl();
            int index = imgUrl.lastIndexOf("com/");
            String fileName = imgUrl.substring(index+4,imgUrl.length());
            String realName = fileName.replace("/","_");
            String lastName = lastPath+realName;
            int result = ProjectUtils.downLoadImg(imgUrl,lastName);
            log.info("下载数据结果-----"+result);
            String insertUrl = baseUrl+ realName;
            v.setImgUrl(insertUrl);
            v.setUpdateFlag(ImgFlagEnums.YES.getCode());
            if(result == 200){
                int updateResult = tbGarmentHistoryMapper.updateTbGarmentHistory(v);
                log.info("修改结果"+updateResult);
            }
        });
    }


}
