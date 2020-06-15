package com.lzw.consumer.controller;

import com.lzw.consumer.feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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

    @GetMapping("test")
    public String test() {
        return feign.test();
    }


}
