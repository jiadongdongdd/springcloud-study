package com.study.springcloud.eureka.eurekaservicefeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Feign是一个声明式的伪Http客户端，它使得写Http客户端变得更简单。使用Feign，只需要创建一个接口并注解。它具有可插拔的注解特性，可使用Feign 注解和JAX-RS注解。Feign支持可插拔的编码器和解码器。Feign默认集成了Ribbon，并和Eureka结合，默认实现了负载均衡的效果
 * <p>
 * EnableDiscoveryClient 想服务中心注册
 * EnableFeignClients 开启Feign的功能
 * EnableHystrixDashboard 开启熔断器仪表盘功能，提供可视化的服务页面
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrixDashboard
public class EurekaServiceFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceFeignApplication.class, args);
    }

}
