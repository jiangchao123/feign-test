package com.dianwoba.conf;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by dwb on 2017/4/13.
 */
@Configuration
public class RemoteAddConfiguration {
        /*
        @Bean
        public IPing ribbonPing() {
            return new PingUrl();
        }*/

    /**
     * Ribbon负载均衡策略实现
     * 使用ZoneAvoidancePredicate和AvailabilityPredicate来判断是否选择某个server，前一个判断判定一个zone的运行性能是否可用，
     * 剔除不可用的zone（的所有server），AvailabilityPredicate用于过滤掉连接数过多的Server。
     *
     * @return

     @Bean
     IRule zoneAvoidanceRule() {
     return new ZoneAvoidanceRule();
     }*/

    /**
     * Ribbon负载均衡策略实现
     * 随机选择一个server。
     *
     * @return
     */
    @Bean
    @Primary
    IRule randomRule() {
        return new RandomRule();
    }

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }

    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}