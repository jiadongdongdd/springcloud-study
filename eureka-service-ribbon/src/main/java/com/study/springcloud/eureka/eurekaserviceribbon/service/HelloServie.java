package com.study.springcloud.eureka.eurekaserviceribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 服务调用
 *
 * @author lenovo
 */
@Service
public class HelloServie {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 通过restTemplate+ribbon,调用其他服务
     * HystrixCommand 实现熔断器的功能，如果访问的服务已断开或异常，则自动停止访问并指定了fallbackMethod熔断方法
     *
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "fallback")
    public String helloService(String name) {
        return restTemplate.getForObject("http://EUREKA-SERVICE/hello?name=" + name, String.class);
    }

    /**
     * 熔断方法
     *
     * @param name
     * @return
     */
    public String fallback(String name) {
        return "hello " + name + " error";
    }
}
