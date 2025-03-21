package com.hrf.spring.cloud.gateway.demo.filter;


import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Configuration
public class KeyResolverConfig {

    @Bean
    public KeyResolver userKeyResolver() {
        return exchange ->
                Mono.just(exchange.getRequest().getHeaders().getFirst("token"));
    }
}
