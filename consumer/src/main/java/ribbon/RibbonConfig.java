package ribbon;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: 1.0
 * @description:
 * @author: zhiwei.liao
 * @create: 2020-06-11 09:31:07
 **/
@Configuration
public class RibbonConfig {

    @Bean
    public IRule myRule(){
        return new RoundRobinRule();
    }
}
