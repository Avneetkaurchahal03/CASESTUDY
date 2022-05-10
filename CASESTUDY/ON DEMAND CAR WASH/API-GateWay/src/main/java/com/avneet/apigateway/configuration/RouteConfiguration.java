package com.avneet.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder routeLocatorBuilder)
	{
	return routeLocatorBuilder.routes()


	
	.route(p ->p
			.path("/admin/*")
			.uri("http://localhost:8081"))
	
	.route(p ->p
			.path("/us/*")
			.uri("http://localhost:8082"))
	

	.route(p ->p
			.path("/od/*")
			.uri("http://localhost:8083"))
			
	
	
	.route(p ->p
			.path("/wash/*")
			.uri("http://localhost:8084"))
	        .build();
	
	
	}
	

	}
