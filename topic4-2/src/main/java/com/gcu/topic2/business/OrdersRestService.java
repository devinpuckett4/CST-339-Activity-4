package com.gcu.topic2.business;

import com.gcu.topic2.model.OrderList;
import com.gcu.topic2.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class OrdersRestService {

    @Autowired
    private OrdersBusinessInterface service;

    @GetMapping(path = "/getjson", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderModel> getOrdersAsJson() {
        return service.getOrders();
    }

    @GetMapping(path = "/getxml", produces = MediaType.APPLICATION_XML_VALUE)
    public OrderList getOrdersAsXml() {
        OrderList wrapper = new OrderList();
        wrapper.setOrders(service.getOrders());
        return wrapper;
    }
}