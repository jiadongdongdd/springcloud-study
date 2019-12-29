package com.study.springcloud.eureka.eurekaserviceribbon.controller;

import com.study.springcloud.eureka.eurekaserviceribbon.service.HelloServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloServie helloServie;

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return helloServie.helloService(name);
    }
}
