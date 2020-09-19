package com.mymax.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.servlet.http.HttpServletRequest;

public class SimpleFilter extends ZuulFilter {
	
	@Autowired
    Environment environment;
	
   private static Logger LOGGER = LoggerFactory.getLogger(SimpleFilter.class);
   @Override
   public String filterType() {
       return "pre";
   }
   @Override
   public int filterOrder() {
       return 1;
   }
   @Override
   public boolean shouldFilter() {
       return true;
   }
   @Override
   public Object run() {
	   
	   String serverPort = environment.getProperty("server.port");
		LOGGER.info("Port : " + serverPort);
		
       RequestContext ctx = RequestContext.getCurrentContext();
       HttpServletRequest request = ctx.getRequest();
       LOGGER.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
       return null;
   }
}