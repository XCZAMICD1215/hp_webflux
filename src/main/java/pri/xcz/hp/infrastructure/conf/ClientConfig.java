package pri.xcz.hp.infrastructure.conf;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
public class ClientConfig {

    @LoadBalanced
    @Bean(name="loadBalancedWebClientBuilder")
    @ConditionalOnMissingBean(name = "loadBalancedWebClientBuilder")
    public WebClient.Builder loadBalancedWebClientBuilder(){
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(HttpClient.create().wiretap(true)));
    }

    @Bean(name="webClientBuilder")
    @ConditionalOnMissingBean(name = "webClientBuilder")
    public WebClient.Builder webClientBuilder(){
        return WebClient.builder().clientConnector(new ReactorClientHttpConnector(HttpClient.create().wiretap(true)));
    }


}
