package com.study.springcloud.servicegateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrictController {

    @RequestMapping("/fallback")
    public String fallback(){
        return "服务已关闭";
    }
}
