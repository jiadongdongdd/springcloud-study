package com.study.springcloud.gatewayfilter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/result")
public class ResultController {

    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
