package com.gcu.topic2.data;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.topic2.data.entity.OrderEntity;
import com.gcu.topic2.data.repository.OrdersRepository;
@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity> {
    @Autowired private OrdersRepository ordersRepository;
    public OrdersDataService(OrdersRepository ordersRepository){ this.ordersRepository = ordersRepository; }
    @Override public OrderEntity findById(int id){ return null; }
    @Override public List<OrderEntity> findAll(){
        List<OrderEntity> orders = new ArrayList<>();
        try { Iterable<OrderEntity> it = ordersRepository.findAll(); it.forEach(orders::add); }
        catch(Exception e){ e.printStackTrace(); }
        return orders;
    }
    @Override public boolean create(OrderEntity order){
        try { ordersRepository.save(order); return true; } catch(Exception e){ e.printStackTrace(); return true; }
    }
    @Override public boolean update(OrderEntity order){ return true; }
    @Override public boolean delete(OrderEntity order){ return true; }
}
