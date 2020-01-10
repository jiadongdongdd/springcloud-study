package com.study.springcloud.gatewayfilter;

import com.study.springcloud.gatewayfilter.filter.RequestTimeFilter;
import com.study.springcloud.gatewayfilter.filter.TokenFilter;
import com.study.springcloud.gatewayfilter.filter.factory.RequestTimeGatewayFilterFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayFilterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayFilterApplication.class, args);
    }

    /**
     * 注入全局过滤器（通过globalfile实现）
     * @return
     */
    @Bean
    public TokenFilter tokenFilter(){
        return new TokenFilter();
    }

    /**
     * 将自定义的过滤器工厂注入
     * @return
     */
    @Bean
    public RequestTimeGatewayFilterFactory elapsedGatewayFilterFactory() {
        return new RequestTimeGatewayFilterFactory();
    }
    /**
     * 过滤器注册到router中
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/customer/**")
                        .filters(f -> f.filter(new RequestTimeFilter()))
                        .uri("http://httpbin.org:80/get")
                        .order(0)
                        .id("customer_filter_router")
                )
                .build();
    }

}
