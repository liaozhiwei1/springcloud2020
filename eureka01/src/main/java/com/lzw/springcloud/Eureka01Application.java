package com.lzw.springcloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Auto Ranking module
 *
 * @author sunml
 * @since 2020-01-16 18:22
 */
@SpringBootApplication
@EnableEurekaServer
public class Eureka01Application {

    public static void main(String[] args) {
        SpringApplication.run(Eureka01Application.class, args);
    }

}