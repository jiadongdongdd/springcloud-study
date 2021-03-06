package com.study.springcloud.gatewaypredicate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Predicate 接受一个输入参数，返回一个布尔值结果。该接口包含多种默认方法来将Predicate组合成其他复杂的逻辑（比如：与，或，非）。
 * 可以用于接口请求参数校验、判断新老数据是否有变化需要进行更新操作。add--与、or--或、negate--非。
 */
@SpringBootApplication
public class GatewayPredicateApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayPredicateApplication.class, args);
    }

}
