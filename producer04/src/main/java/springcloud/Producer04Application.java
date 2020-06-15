package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * Auto Ranking module
 *
 * @author sunml
 * @since 2020-01-16 18:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Producer04Application {

    public static void main(String[] args) {
        SpringApplication.run(Producer04Application.class, args);
    }

}