package com.lzw.springcloud.controller;

import com.lzw.springcloud.Fallback.DefaultFallBack;
import com.lzw.springcloud.server.TestServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @version: 1.0
 * @description:
 * @author: zhiwei.liao
 * @create: 2020-06-08 11:22:37
 **/
@RestController
@RequestMapping("/cloudtest")
@RefreshScope
public class getStatus {

    @Value("${server.port}")
    private String port;

    @Value("${a.b}")
    private String a;

    @Resource
    private DiscoveryClient discoveryClient;

    @Autowired
    private TestServer testServer;

    @Autowired
    private DefaultFallBack defaultFallBack;

    @PostMapping("/ok")
    public String test(@RequestBody int x){
        try {
            TimeUnit.MILLISECONDS.sleep(x);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "ok"+port+"   "+a;
    }

    @GetMapping("/get")
//    @HystrixCommand(fallbackMethod = "fallBack",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
//    })
    public String getPort(){
        return testServer.getPort();
    }

    public String fallBack(){
        return defaultFallBack.defaultFallBack();
    }
}
