package com.techprimers.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@EnableJpaRepositories(basePackages = "com.techprimers.db.repository")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SpringBootMysqldbApplication{
	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootMysqldbApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}
}
