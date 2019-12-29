package com.study.springcloud.eureka.eurekaserviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * EnableDiscoveryClient向服务中心注冊
 * EnableHystrix  启动Hystrix（熔断器） 支持
 * EnableHystrixDashboard 启动熔断器仪表盘的支持，支持可视化的服务页面
 *
 * @author lenovo
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableHystrixDashboard
public class EurekaServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceRibbonApplication.class, args);
    }

    /**
     * LoadBalanced 注解表明这个restRemplate开启负载均衡的功能。
     *
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
