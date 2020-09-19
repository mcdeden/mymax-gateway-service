package com.mymax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.mymax.filter.SimpleFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class MymaxGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MymaxGatewayServerApplication.class, args);
	}
	
	@Bean
	  public SimpleFilter simpleFilter() {
	    return new SimpleFilter();
	  }

}
