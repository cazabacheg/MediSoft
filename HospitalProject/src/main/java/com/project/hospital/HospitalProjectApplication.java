package com.project.hospital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})//,HibernateJpaAutoConfiguration.class})
@EnableFeignClients
@EnableDiscoveryClient
public class HospitalProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalProjectApplication.class, args);
	}

}
