package com.study.springcloud.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * RefreshScope spring cloud提供的一种特殊的scope实现，用来实现配置、实例热加载
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${server.name}")
    String serverName;

    @RequestMapping("getConfig")
    public String getConfig(){
        return serverName;
    }
}
