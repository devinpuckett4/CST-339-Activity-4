package com.gcu.topic2.data;
import java.util.ArrayList; import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import com.gcu.topic2.model.OrderModel;

@Service
public class OrdersDataService implements DataAccessInterface<OrderModel> {
  @Autowired private DataSource dataSource;
  @Autowired private JdbcTemplate jdbcTemplateObject;
  public OrdersDataService(DataSource ds){ this.dataSource=ds; this.jdbcTemplateObject=new JdbcTemplate(ds); }

  @Override
  public List<OrderModel> findAll(){
    List<OrderModel> orders = new ArrayList<>();
    try{
      SqlRowSet srs = jdbcTemplateObject.queryForRowSet("SELECT * FROM ORDERS");
      while(srs.next()){
        orders.add(new OrderModel(
          srs.getLong("ID"),
          srs.getString("ORDER_NO"),
          srs.getString("PRODUCT_NAME"),
          srs.getFloat("PRICE"),
          srs.getInt("QUANTITY")));
      }
    }catch(Exception e){ e.printStackTrace(); }
    return orders;
  }
  @Override public OrderModel findById(int id){ return null; }
  @Override public boolean create(OrderModel o){
    try{
      int rows = jdbcTemplateObject.update("INSERT INTO ORDERS(ORDER_NO, PRODUCT_NAME, PRICE, QUANTITY) VALUES(?, ?, ?, ?)",
        o.getOrderNo(), o.getProductName(), o.getPrice(), o.getQuantity());
      return rows==1;
    }catch(Exception e){ e.printStackTrace(); return false; }
  }
  @Override public boolean update(OrderModel o){ return true; }
  @Override public boolean delete(OrderModel o){ return true; }
}