package com.jiangchao.feign.controller;

import com.jiangchao.feign.hystrix.HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangchao08 on 17/4/23.
 */
@RestController
public class FeignHystrixTest {

    @Autowired
    HelloClient helloClient;

    @ResponseBody
    @RequestMapping(value = "/test")
    public String services() {
        String result = helloClient.getAnswerResult();
        return result;
    }
}
