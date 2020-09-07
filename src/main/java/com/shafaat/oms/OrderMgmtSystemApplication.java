package com.shafaat.oms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrderMgmtSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMgmtSystemApplication.class, args);
	}

}
