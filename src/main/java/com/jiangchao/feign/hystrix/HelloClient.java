package com.jiangchao.feign.hystrix;

import com.jiangchao.feign.FeignConfigure;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jiangchao08 on 17/4/22.
 */
@FeignClient(value = "spring-boot-demo", fallback = HelloClientFallback.class, configuration = FeignConfigure.class)
public interface HelloClient {

    @RequestMapping(method = RequestMethod.POST, value = "/test/hello")
    public String getAnswerResult();

}
