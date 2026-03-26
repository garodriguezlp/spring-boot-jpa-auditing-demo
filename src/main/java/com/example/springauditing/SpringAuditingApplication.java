package com.example.springauditing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpringAuditingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAuditingApplication.class, args);
	}

}
