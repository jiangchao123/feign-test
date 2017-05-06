package com.jiangchao.feign.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangchao08 on 17/4/24.
 */
@RestController
@RequestMapping(value = "/test")
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public String unit() {

        String response = "hello world hello world hello world hello world hello world hello world hello world ";
        logger.info("response: " + response);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

}
