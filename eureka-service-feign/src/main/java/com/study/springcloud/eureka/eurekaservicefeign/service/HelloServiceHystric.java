package com.study.springcloud.eureka.eurekaservicefeign.service;

import org.springframework.stereotype.Component;

/**
 * 服务访问失败，熔断方法
 */
@Component
public class HelloServiceHystric implements HelloService {
    @Override
    public String sayHelloFromClient(String name) {
        return "sorry " + name;
    }
}
