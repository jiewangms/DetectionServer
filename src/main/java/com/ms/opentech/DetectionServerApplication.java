package com.ms.opentech;

import com.ms.opentech.services.interfaces.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DetectionServerApplication {
	private static final Logger logger = LoggerFactory.getLogger(DetectionServerApplication.class.getSimpleName());

	public static void main(String[] args) {
		SpringApplication.run(DetectionServerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.init();
		};
	}
}
