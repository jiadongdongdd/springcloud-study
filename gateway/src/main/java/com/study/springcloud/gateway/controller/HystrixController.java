package com.study.springcloud.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author lenovo
 */
@RestController
public class HystrixController {
    /**
     * Mono是一个Reactive stream
     * @return
     */
//    @RequestMapping("/fallback")
//    public Mono<String> fallback() {
//        //对外输出一个“fallback”字符串。
//        return Mono.just("fallback");
//    }

    /**
     *服务异常
     * @return
     */
    @RequestMapping("/fallback")
    public String fallback() {
        return "服务器开小差了，请稍等...";
    }

    /**
     * 正常访问
     * @return
     */
    @RequestMapping("/success")
    public String success(){
        return "访问成功！";
    }
}
