package com.garment.web.service.task;

import com.garment.common.core.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author leedan
 * @Description :
 * @Date 2023/11/15  10:12
 * @Version 1.0
 */
public class AITxt2ImgTask  implements Runnable{

    String temp;

    public AITxt2ImgTask(String str) {
        this.temp = temp;
    }

    @Autowired
    private RedisCache redisCache;


    @Override
    public void run() {

//         System.out.println();
//         redisCache.getCacheList("");

    }
}
