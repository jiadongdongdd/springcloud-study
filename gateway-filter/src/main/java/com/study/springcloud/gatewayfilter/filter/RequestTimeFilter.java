package com.study.springcloud.gatewayfilter.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义过滤器
 */
public class RequestTimeFilter implements GatewayFilter, Ordered {

    private static final Log log = LogFactory.getLog(RequestTimeFilter.class);
    private static final String REQUEST_TIME_BEGIN = "requestTimeBegin";

    /**
     * 过滤器逻辑
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //先记录了请求的开始时间，并保存在ServerWebExchange中，此处是一个“pre”类型的过滤器
        exchange.getAttributes().put(REQUEST_TIME_BEGIN, System.currentTimeMillis());

        return chain.filter(exchange).then(

                Mono.fromRunnable(() -> {
                    //然后再chain.filter的内部类中的run()方法中相当于”post”过滤器，在此处打印了请求所消耗的时间
                    Long startTime = exchange.getAttribute(REQUEST_TIME_BEGIN);
                    if (startTime != null) {
                        log.info(exchange.getRequest().getURI().getRawPath() + ":" + (System.currentTimeMillis() - startTime));
                    }
                })
        );
    }

    /**
     * 加载顺序，编号越大加载越晚
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
