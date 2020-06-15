package com.lzw.springcloud.server;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @version: 1.0
 * @description:
 * @author: zhiwei.liao
 * @create: 2020-06-12 12:40:28
 **/
@Service
public class TestServer {

    @Resource
    private DiscoveryClient discoveryClient;

    public String getPort(){
//        int a = 10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> instances = discoveryClient.getInstances("PRODUCER");
        StringBuffer stringBuffer = new StringBuffer();
        for (ServiceInstance s :
                instances) {
            String host = s.getHost();
            String s1 = s.getUri().toString();
            stringBuffer.append(host+"****").append(s1);
        }
        return stringBuffer.toString();
    }
}
