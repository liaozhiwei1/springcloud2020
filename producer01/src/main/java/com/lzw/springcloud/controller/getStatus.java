package com.lzw.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version: 1.0
 * @description:
 * @author: zhiwei.liao
 * @create: 2020-06-08 11:22:37
 **/
@RestController
@RequestMapping("/cloudtest")
public class getStatus {

    @Value("${server.port}")
    private String port;

    @GetMapping("/ok")
    public String test(){
        return "ok"+port;
    }
}
