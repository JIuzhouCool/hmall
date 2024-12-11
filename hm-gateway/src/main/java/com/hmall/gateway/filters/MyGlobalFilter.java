package com.hmall.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取上下文的header
        HttpHeaders headers = exchange.getRequest().getHeaders();
        System.out.println("headers:"+headers);
        //继续执行过滤器链
        return chain.filter(exchange);
    }
    //设置自定义过滤器链的优先级，数字越小优先级越高
    @Override
    public int getOrder() {
        return 0;
    }
}
