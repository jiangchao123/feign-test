package com.dianwoba.app.web;

import com.dianwoba.app.service.RemoteAddService;
import com.dianwoba.app.service.RemoteMultiplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Autowired
    private RemoteAddService remoteAddService;

    @Autowired
    private RemoteMultiplyService remoteMultiplyService;

    @Value("${from}")
    private String from;

    @RequestMapping("/from")
    public String from() {
        return this.from;
    }

    @RequestMapping("/remote/add")
    public Integer add(Integer a,Integer b) {
        return remoteAddService.add(a,b);
    }

    @RequestMapping("/remote/multiply")
    public Integer multiply(Integer a,Integer b) {
        return remoteMultiplyService.multiply(a,b);
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }

}