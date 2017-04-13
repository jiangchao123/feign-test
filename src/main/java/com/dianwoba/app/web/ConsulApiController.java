package com.dianwoba.app.web;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.health.model.Check;
import com.ecwid.consul.v1.health.model.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by dwb on 2017/4/11.
 */
@RestController
public class ConsulApiController {

    @Autowired
    private ConsulClient consulClient;

    @RequestMapping(value = "/unregister/{id}", method = RequestMethod.GET)
    public String unregisterServiceAll(@PathVariable String id) {
        List<HealthService> response = consulClient.getHealthServices(id, false, null).getValue();
        for(HealthService service : response) {
            service.getChecks().forEach(check -> {
                if(!check.getStatus().name().equals(Check.CheckStatus.PASSING.name())) {
                    //logger.info("unregister : {}", check.getServiceId());
                    System.out.println(check.getServiceId());
                    consulClient.agentServiceDeregister(check.getServiceId());
                }
            });
        }
        return null;
    }
}
