package com.gcu.topic2.business;

import com.gcu.topic2.model.OrderModel;   // <-- FIXED
import java.util.ArrayList;
import java.util.List;

public class OrdersBusinessService2 implements OrdersBusinessInterface {
    @Override
    public void test() {
        System.out.println("Hello from the AnotherOrdersBusinessService.test()");
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> list = new ArrayList<>();
        list.add(new OrderModel(10, "B1001", "Keyboard", 39.99f, 1));
        list.add(new OrderModel(11, "B1002", "Webcam", 59.99f, 1));
        return list;
    }
}
