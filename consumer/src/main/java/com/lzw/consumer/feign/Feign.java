package com.lzw.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @version: 1.0
 * @description:
 * @author: zhiwei.liao
 * @create: 2020-06-11 15:04:21
 **/
@Component
@FeignClient(value = "nacos-producer")
public interface Feign {

    @GetMapping("/cloudtest/get")
    String getPort();

    @PostMapping("/cloudtest/ok")
    String test(@RequestBody int x);
}
