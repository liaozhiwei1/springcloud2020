package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @version: 1.0
 * @description:
 * @author: zhiwei.liao
 * @create: 2020-06-08 11:22:37
 **/
@RestController
@RequestMapping("/cloudtest")
public class getStatus {

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @GetMapping("/ok")
    public String test(){
        return "ok"+port;
    }

    @GetMapping("/get")
    public String getPort(){
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
