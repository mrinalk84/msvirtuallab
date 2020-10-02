package com.ibm.taxservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TaxserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxserviceApplication.class, args);
	}

}
