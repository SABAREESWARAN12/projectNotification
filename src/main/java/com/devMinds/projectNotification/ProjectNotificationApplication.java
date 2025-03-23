package com.devMinds.projectNotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
@EnableScheduling
@EnableAsync
public class ProjectNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectNotificationApplication.class, args);
	}

}
