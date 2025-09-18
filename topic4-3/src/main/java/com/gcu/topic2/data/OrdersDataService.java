package com.gcu.topic2.data;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.gcu.topic2.data.entity.OrderEntity;
import com.gcu.topic2.data.repository.OrdersRepository;
@Service
public class OrdersDataService implements DataAccessInterface<OrderEntity> {
    @Autowired private OrdersRepository ordersRepository;
    @Autowired private DataSource dataSource;
    @Autowired private JdbcTemplate jdbcTemplateObject;
    public OrdersDataService(OrdersRepository ordersRepository, DataSource dataSource){
        this.ordersRepository = ordersRepository;
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    @Override public OrderEntity findById(int id){ return null; }
    @Override public List<OrderEntity> findAll(){
        List<OrderEntity> orders = new ArrayList<>();
        try { ordersRepository.findAll().forEach(orders::add); } catch(Exception e){ e.printStackTrace(); }
        return orders;
    }
    @Override public boolean create(OrderEntity order){
        try {
            String sql = "INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)";
            int rows = jdbcTemplateObject.update(sql, order.getOrderNo(), order.getProductName(), order.getPrice(), order.getQuantity());
            return rows == 1;
        } catch(Exception e){ e.printStackTrace(); return false; }
    }
    @Override public boolean update(OrderEntity order){ return true; }
    @Override public boolean delete(OrderEntity order){ return true; }
}
