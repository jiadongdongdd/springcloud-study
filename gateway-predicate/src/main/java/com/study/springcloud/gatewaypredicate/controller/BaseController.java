package com.study.springcloud.gatewaypredicate.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @RequestMapping("/get")
    public String get(){
        return "success";
    }

    @RequestMapping("/after")
    public String afterRouteResult(){
        return "after route";
    }
}
