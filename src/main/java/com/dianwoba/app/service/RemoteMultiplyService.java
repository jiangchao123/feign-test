package com.dianwoba.app.service;

import com.dianwoba.conf.RemoteMultiplyConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by dwb on 2017/4/11.
 */
@FeignClient(name = "spring-cloud-consul-service",configuration = RemoteMultiplyConfiguration.class)
public interface RemoteMultiplyService {

    //@Headers({"Content-Type: application/json","Accept: application/json"})
    @RequestMapping(method = RequestMethod.GET, value = "/multiply")
    Integer multiply(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);

}



