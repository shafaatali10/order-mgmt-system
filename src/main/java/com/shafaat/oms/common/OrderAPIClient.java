package com.shafaat.oms.common;

import com.shafaat.oms.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "orderAPIClient", url = "http://localhost:8080/orders")
public interface OrderAPIClient {

    @GetMapping
    List<OrderDTO> getOrders();

    @GetMapping("/{orderId}")
    OrderDTO getOrder(@PathVariable("orderId") Integer orderId);

}
