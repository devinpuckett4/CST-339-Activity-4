package com.gcu.topic2.business;

import com.gcu.topic2.model.OrderModel;   // <-- FIXED
import java.util.ArrayList;
import java.util.List;

public class OrdersBusinessService implements OrdersBusinessInterface {
    @Override
    public void test() {
        System.out.println("Hello from the OrdersBusinessService.test()");
    }

    @Override
    public List<OrderModel> getOrders() {
        List<OrderModel> list = new ArrayList<>();
        list.add(new OrderModel(1, "A0001", "Laptop", 999.99f, 1));
        list.add(new OrderModel(2, "A0002", "Mouse", 19.99f, 2));
        list.add(new OrderModel(3, "A0003", "Headset", 49.99f, 1));
        return list;
    }
}
