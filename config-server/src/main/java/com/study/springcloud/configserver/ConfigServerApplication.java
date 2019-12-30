package com.study.springcloud.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * EnableConfigServer启动服务配置
 * EnableEurekaClient 启动服务注册支持
 */
@EnableConfigServer
@SpringBootApplication
@EnableEurekaClient
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }

}
