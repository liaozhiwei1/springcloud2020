package com.lzw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * Auto Ranking module
 *
 * @author sunml
 * @since 2020-01-16 18:22
 */
@SpringBootApplication
@EnableEurekaClient
public class Producer01Application {

    public static void main(String[] args) {
        SpringApplication.run(Producer01Application.class, args);
    }

}