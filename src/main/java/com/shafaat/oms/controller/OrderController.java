package com.shafaat.oms.controller;

import com.shafaat.oms.common.OrderNotFoundException;
import com.shafaat.oms.dto.OrderDTO;
import com.shafaat.oms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<OrderDTO> getAllOrders(){
        return orderService.listOrders();
    }

    @GetMapping("/orders/{orderId}")
    public OrderDTO getOrder(@PathVariable Integer orderId){
        if(orderService.getOrder(orderId)!=null){
            return orderService.getOrder(orderId);
        }else{
            throw new OrderNotFoundException("Order not found for OrderId " + orderId );
        }

    }

    @PostMapping("/orders")
    public OrderDTO createOrder(@Valid @RequestBody OrderDTO dto){
        return orderService.createOrder(dto);
    }


}
