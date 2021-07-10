package com.aquicksoftEventPublisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication

@EnableAsync
public class AquicksoftEventPublisherApplication {

	private static Logger logger = LoggerFactory.getLogger(AquicksoftEventPublisherApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AquicksoftEventPublisherApplication.class, args);
		logger.info("Producer application started successfully");
	}
}
