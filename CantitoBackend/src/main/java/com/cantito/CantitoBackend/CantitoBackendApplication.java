package com.cantito.CantitoBackend;

import com.cantito.CantitoBackend.entities.User;
import com.cantito.CantitoBackend.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class CantitoBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CantitoBackendApplication.class, args);

	}

}
