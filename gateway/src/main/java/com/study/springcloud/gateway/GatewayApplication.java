package com.study.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Cloud Gateway依赖Spring Boot和Spring Webflux提供的Netty runtime。它不能在传统的Servlet容器中工作或构建为WAR
 * Spring Cloud Gateway是Spring Cloud官方推出的第二代网关框架，取代Zuul网关。
 * 网关作为流量的，在微服务系统中有着非常作用，网关常见的功能有路由转发、权限校验、限流控制等作用。
 */
@SpringBootApplication
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    /**
     * 使用RouteLocator的Bean进行路由转发，将请求进行处理，最后转发到目标的下游服务。在本案例中，会将请求转发到http://httpbin.org:80这个地址上
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        //请求地址
                        .path("/get")
                        //添加了一个filter，该filter会将请求添加一个header请求头添加参数
                        .filters(f -> f.addRequestHeader("Hello", "World"))
                        //重定向地址、路由地址
                        .uri("http://localhost:8080/success"))
                .route(p -> p
                        //当请求的host有“*.hystrix.com”
                        .host("*.hystrix.com")
                        //.path("/hystrix")
                        .filters(f -> f
                                //该filter可以配置名称、和指向性fallback的逻辑的地址
                                .hystrix(config -> config
                                        .setName("mycmd")
                                        .setFallbackUri("forward:/fallback")))
                        //重定向地址、路由地址
                        .uri("http://localhost:8080/error"))
                .build();
    }
}
