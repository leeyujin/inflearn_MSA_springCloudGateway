package com.example.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r.path("/first-service/**") // 사용자 요청이 들어오면
                            .filters( f -> f.addRequestHeader("first-request","first-request-header")
                                            .addResponseHeader("first-response","first-response-header"))
                            .uri("http://localhost:8081") // 이곳으로 이동 시킴
                )
                .route(r -> r.path("/second-service/**") // 사용자 요청이 들어오면
                        .filters( f -> f.addRequestHeader("second-request","second-request-header")
                                .addResponseHeader("second-response","second-response-header"))
                        .uri("http://localhost:8082") // 이곳으로 이동 시킴
                )
                .build();
    }
}
