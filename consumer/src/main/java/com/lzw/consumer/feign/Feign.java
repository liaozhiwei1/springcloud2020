package com.lzw.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @version: 1.0
 * @description:
 * @author: zhiwei.liao
 * @create: 2020-06-11 15:04:21
 **/
@Component
@FeignClient(value = "PRODUCER")
public interface Feign {

    @GetMapping("/cloudtest/get")
    String getPort();

    @GetMapping("/cloudtest/ok")
    String test();

}
