package com.shafaat.oms.dto;

import com.shafaat.oms.entity.OrderItem;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class OrderDTO {
    private Integer orderId;

    @NotNull(message="customerName can't be empty")
    private String customerName;

    @NotNull(message="Date can't be null")
    private Date orderDate;

    @NotNull(message="shippingAddress can't be null")
    private String shippingAddress;

    private List<OrderItem> orderItems;
    private Float total;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
}
