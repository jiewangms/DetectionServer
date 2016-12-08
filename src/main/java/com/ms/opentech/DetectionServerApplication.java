package com.ms.opentech;

import com.ms.opentech.storage.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DetectionServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DetectionServerApplication.class, args);
	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> storageService.init();
	}

}
