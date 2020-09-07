package com.shafaat.oms.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="order_item_table")
public class OrderItem {

    @Id
    @GeneratedValue
    private Integer orderItemId;
    private String productCode;
    private String productName;
    private Integer quantity;
    private Integer orderId;

    @ManyToOne
    private Order order;

    public Integer getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Integer orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
