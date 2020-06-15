package com.lzw.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * Auto Ranking module
 *
 * @author sunml
 * @since 2020-01-16 18:22
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
@EnableEurekaClient
//@RibbonClient(name = "PRODUCER",configuration = RibbonConfig.class)
@EnableFeignClients
public class consumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(consumerApplication.class, args);
    }

}