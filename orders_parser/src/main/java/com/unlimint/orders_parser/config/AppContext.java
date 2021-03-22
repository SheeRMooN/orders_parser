package com.unlimint.orders_parser.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@ComponentScan(basePackages = "com.unlimint.orders_parser")
@EnableAsync
public class AppContext {

}
