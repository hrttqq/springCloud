package com.hrf.spring.cloud.gateway.demo.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 根据匹配规则进行过滤
 * 自定义过滤器 打印耗时日志
 */
@Component
@Slf4j
public class LogTimeGatewayFilterFactory extends AbstractGatewayFilterFactory<LogTimeGatewayFilterFactory.Config> {
    public LogTimeGatewayFilterFactory() {
        super(LogTimeGatewayFilterFactory.Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        String serviceName = config.getServiceName();
        return (exchange, chain) -> {
            long startTime = System.currentTimeMillis();
            String path = exchange.getRequest().getPath().toString();
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                long duration = System.currentTimeMillis() - startTime;
                log.info(serviceName + "请求" + path + "耗时：" + duration + "ms");
                //System.out.println(serviceName + "请求耗时：" + duration + "ms");
            }));
        };
    }

    public static class Config {

        private String serviceName;

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

    }
}
