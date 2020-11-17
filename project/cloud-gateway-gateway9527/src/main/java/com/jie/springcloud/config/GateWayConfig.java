package com.jie.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenxiaojie
 * @date: 2020/10/25
 * @time: 23:36
 * @description: TODO
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocator build = routeLocatorBuilder.routes().route("path_rote_jie1", r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei")).build();
        return build;
    }
}
