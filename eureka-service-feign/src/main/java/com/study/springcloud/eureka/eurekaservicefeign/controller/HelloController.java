package com.study.springcloud.eureka.eurekaservicefeign.controller;

import com.study.springcloud.eureka.eurekaservicefeign.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    public HelloService helloService;

    @RequestMapping("sayHello")
    public String sayHello(@RequestParam String name) {
        return helloService.sayHelloFromClient(name);
    }

}
