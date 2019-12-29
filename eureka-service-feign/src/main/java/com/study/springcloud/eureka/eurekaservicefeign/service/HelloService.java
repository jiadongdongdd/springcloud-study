package com.study.springcloud.eureka.eurekaservicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Feign已集成rebbon、hystrix， value:访问服务名称 ，fallback：熔断方法，服务异常不可访问时的处理类
 *
 * @author lenovo
 */
@FeignClient(value = "eureka-service", fallback = HelloServiceHystric.class)
public interface HelloService {

    /**
     * 访问 eureka-service服务暴露接口helllo
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHelloFromClient(@RequestParam(value = "name") String name);
}
