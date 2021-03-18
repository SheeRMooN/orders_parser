package com.unlimint.orders_parser.config;

import com.unlimint.orders_parser.Orders;
import com.unlimint.orders_parser.model.Order;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.unlimint.orders_parser")
public class AppContext {

//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    public Order order(){
//        return new Order();
//    }
//
//    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//    public Orders orders(){
//        return new Orders();
//    }
}
