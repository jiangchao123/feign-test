package com.dianwoba.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = "com.dianwoba.app.service")
/*@ComponentScan(
		//basePackages = {"com.dianwoba.app.service","com.dianwoba.app.web"}
		excludeFilters = @ComponentScan.Filter(
				value= Configuration.class,
				type = FilterType.ANNOTATION
		)
)*/
public class ConfigClientApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ConfigClientApplication.class).web(true).run(args);
	}

}
