package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@Slf4j
@SpringBootApplication
public class OptimisticVsPessimisticLockingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OptimisticVsPessimisticLockingApplication.class, args);
	}

	@Bean
	ApplicationRunner init(){
		return args -> {
         log.info("Optimistic Vs Pessimistic Locking Application started");
		};
	}

}
