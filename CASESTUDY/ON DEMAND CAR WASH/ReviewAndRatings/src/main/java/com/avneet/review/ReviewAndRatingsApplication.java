package com.avneet.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ReviewAndRatingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewAndRatingsApplication.class, args);
	}

}
