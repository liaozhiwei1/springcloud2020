package com.lzw.springcloud.Fallback;

import org.springframework.stereotype.Component;

/**
 * @version: 1.0
 * @description:
 * @author: zhiwei.liao
 * @create: 2020-06-12 12:43:24
 **/
@Component
public class DefaultFallBack {

    public String defaultFallBack(){
        return Thread.currentThread().getName()+"sorry ";
    }
}
