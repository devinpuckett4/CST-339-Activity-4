package com.gcu.topic2.data.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
@Table("ORDERS")
public class OrderEntity {
    @Id private Long id;
    @Column("ORDER_NO") private String orderNo;
    @Column("PRODUCT_NAME") private String productName;
    @Column("PRICE") private float price;
    @Column("QUANTITY") private int quantity;
    public OrderEntity(){}
    public OrderEntity(Long id,String orderNo,String productName,float price,int quantity){
        this.id=id;this.orderNo=orderNo;this.productName=productName;this.price=price;this.quantity=quantity;
    }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getOrderNo(){return orderNo;} public void setOrderNo(String v){this.orderNo=v;}
    public String getProductName(){return productName;} public void setProductName(String v){this.productName=v;}
    public float getPrice(){return price;} public void setPrice(float v){this.price=v;}
    public int getQuantity(){return quantity;} public void setQuantity(int v){this.quantity=v;}
}
