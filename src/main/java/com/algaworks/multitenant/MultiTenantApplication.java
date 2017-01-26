package com.algaworks.multitenant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class MultiTenantApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiTenantApplication.class, args);
	}
		
}
