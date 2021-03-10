package com.unlimint.orders_parser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class OrdersParserApplication  {

	public static void main(String[] args) {
		SpringApplication.run(OrdersParserApplication.class, args);



		try {
			Orders.main(args);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
