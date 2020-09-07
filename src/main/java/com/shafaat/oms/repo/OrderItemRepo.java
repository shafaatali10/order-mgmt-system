package com.shafaat.oms.repo;

import com.shafaat.oms.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
    List<OrderItem> findByOrderId(Integer orderId);
    Optional<OrderItem> findByOrderItemIdAndOrderId(Integer orderItemId, Integer orderId);

}
