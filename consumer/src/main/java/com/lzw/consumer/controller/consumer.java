package com.lzw.consumer.controller;

import com.lzw.consumer.feign.Feign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version: 1.0
 * @description:
 * @author: zhiwei.liao
 * @create: 2020-06-08 16:22:41
 **/
@RestController
public class consumer {

    @Autowired
    private RestTemplate restTemplate;

    private String url = "http://PRODUCER/cloudtest/ok";

    @Autowired
    private Feign feign;

    @GetMapping("test/{x}")
    @HystrixCommand(fallbackMethod = "getDataFallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000"),
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
            })
    public String test(@PathVariable(name = "x") int x, HttpServletRequest httpServletRequest) {
        return feign.test(x);
    }

    public String getDataFallback(int x, HttpServletRequest httpServletRequest){
        return Thread.currentThread().getName()+"sorry";
    }

    @GetMapping("hytrix/{x}")
    @HystrixCommand(fallbackMethod = "getDataFallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50")
            })
    public String hytrix(@PathVariable(name = "x") int x, HttpServletRequest httpServletRequest){
        if (x<0){
            throw new RuntimeException("11");
        }
        return "....";
    }

}
