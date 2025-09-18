package com.gcu.topic2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gcu.topic2.business.OrdersBusinessInterface;
import com.gcu.topic2.business.OrdersBusinessService;

@Configuration
public class SpringConfig {

    @Bean(name = "ordersBusinessService")
    public OrdersBusinessInterface getOrdersBusiness() {
        return new OrdersBusinessService();      
    }
}