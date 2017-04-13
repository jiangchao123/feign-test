package com.dianwoba.app.service;

import com.dianwoba.conf.RemoteAddConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dwb on 2017/4/7.
 */
@FeignClient(name = "spring-cloud-consul-service",
        configuration = RemoteAddConfiguration.class,
        fallback = HystrixClientFallback.class)
public interface RemoteAddService {

    //@Headers({"Content-Type: application/json","Accept: application/json"})
    @RequestMapping(method = RequestMethod.GET, value = "/add")
    Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}

@Component
class HystrixClientFallback implements RemoteAddService {

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        return -9999;
    }
}



