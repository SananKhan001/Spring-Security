package com.example.updatedspringsecurity;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class UpdatedSpringSecurityApplication implements Runnable{
	public static void main(String[] args) {
		SpringApplication.run(UpdatedSpringSecurityApplication.class, args);
	}

	@Override
	public void run() {
		log.info("=============================================== Application Started===============================================");
	}
}
