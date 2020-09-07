package com.shafaat.oms.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderItemDTO {
    private Integer orderItemId;

    @NotNull(message="Product Code can't be empty")
    private String productCode;

    @NotNull(message="Product Name can't be empty")
    private String productName;

    @NotNull(message="Quantity can't be empty")
    @Min(value =1,message = "Should be a number greater than 0")
    private Integer quantity;

//    @NotNull(message="OrderId can't be empty")
    private Integer orderId;

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
