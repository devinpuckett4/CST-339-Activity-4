package com.gcu.topic2.data.repository;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import com.gcu.topic2.data.entity.OrderEntity;
public interface OrdersRepository extends CrudRepository<OrderEntity, Long> {
    @Query("SELECT * FROM ORDERS")
    List<OrderEntity> findAll();
}
