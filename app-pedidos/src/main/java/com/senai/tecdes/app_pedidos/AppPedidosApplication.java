package com.senai.tecdes.app_pedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppPedidosApplication.class, args);
	}

}
