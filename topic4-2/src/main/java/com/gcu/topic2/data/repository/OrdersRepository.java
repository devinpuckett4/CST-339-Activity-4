package com.gcu.topic2.data.repository;
import org.springframework.data.repository.CrudRepository;
import com.gcu.topic2.data.entity.OrderEntity;
public interface OrdersRepository extends CrudRepository<OrderEntity, Long> { }
