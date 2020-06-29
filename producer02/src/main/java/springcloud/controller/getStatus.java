package springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

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
@RefreshScope
public class getStatus {

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

    @Value("${a.b}")
    private String a;

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
