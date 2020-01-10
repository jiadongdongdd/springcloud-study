package com.study.springcloud.gatewayfilterlimit;

import com.study.springcloud.gatewayfilterlimit.keyResolver.HostAddrKeyResolver;
import com.study.springcloud.gatewayfilterlimit.keyResolver.UriKeyResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GatewayFilterLimitApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayFilterLimitApplication.class, args);
    }

    /**
     * 以用户的维度去限流
     * @return
     */
    @Bean
    KeyResolver userKeyResolver() {
        return new KeyResolver() {
            @Override
            public Mono<String> resolve(ServerWebExchange exchange) {
                return Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
            }
        };
        //return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
    }

    /**
     * 根据uri去限流
     * @return
     */
    @Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }

    /**
     * 通过地址限流
     * @return
     */
    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }
}
