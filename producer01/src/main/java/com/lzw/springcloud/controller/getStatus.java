package com.lzw.springcloud.controller;

import com.lzw.springcloud.Fallback.DefaultFallBack;
import com.lzw.springcloud.server.TestServer;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @version: 1.0
 * @description:
 * @author: zhiwei.liao
 * @create: 2020-06-08 11:22:37
 **/
@RestController
@RequestMapping("/cloudtest")
@DefaultProperties(defaultFallback = "fallBack",commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
})
public class getStatus {

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @Autowired
    private TestServer testServer;

    @Autowired
    private DefaultFallBack defaultFallBack;

    @GetMapping("/ok")
    @HystrixCommand
    public String test(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok"+port;
    }

    @GetMapping("/get")
//    @HystrixCommand(fallbackMethod = "fallBack",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    @HystrixCommand
    public String getPort(){
        return testServer.getPort();
    }

    public String fallBack(){
        return defaultFallBack.defaultFallBack();
    }
}
