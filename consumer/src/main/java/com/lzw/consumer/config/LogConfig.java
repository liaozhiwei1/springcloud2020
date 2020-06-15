package com.lzw.consumer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @version: 1.0
 * @description:
 * @author: zhiwei.liao
 * @create: 2020-06-12 10:30:20
 **/
@Configuration
public class LogConfig {

    @Bean
    public Logger.Level feignLog(){
        return Logger.Level.FULL;
    }

}
