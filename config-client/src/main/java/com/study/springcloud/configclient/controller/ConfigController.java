package com.study.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Value("${foo}")
    String foo;

    @RequestMapping("getConfig")
    public String getConfig(){
        return foo;
    }
}
