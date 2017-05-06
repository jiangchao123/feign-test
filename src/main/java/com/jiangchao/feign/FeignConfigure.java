package com.jiangchao.feign;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jiangchao08 on 17/4/23.
 */
@Configuration
public class FeignConfigure {

//    public static final int connectTimeOutMillis = 10;
//    public static final int readTimeOutMillis = 10;

    public static final int connectTimeOutMillis = 10000;
    public static final int readTimeOutMillis = 10000;

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }

}
