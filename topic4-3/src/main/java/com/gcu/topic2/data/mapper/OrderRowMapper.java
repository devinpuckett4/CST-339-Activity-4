package com.gcu.topic2.data.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.gcu.topic2.data.entity.OrderEntity;
public class OrderRowMapper implements RowMapper<OrderEntity> {
    @Override
    public OrderEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new OrderEntity(
            rs.getLong("ID"),
            rs.getString("ORDER_NO"),
            rs.getString("PRODUCT_NAME"),
            rs.getFloat("PRICE"),
            rs.getInt("QUANTITY")
        );
    }
}
