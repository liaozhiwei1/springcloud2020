package com.lzw.hysrtixDashdoard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * Auto Ranking module
 *
 * @author sunml
 * @since 2020-01-16 18:22
 */
@SpringBootApplication
@EnableAsync
@EnableHystrixDashboard
@EnableCircuitBreaker
public class hystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(hystrixDashboardApplication.class, args);
    }

}