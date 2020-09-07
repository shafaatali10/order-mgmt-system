package com.shafaat.oms.controller;

import com.shafaat.oms.common.OrderNotFoundException;
import com.shafaat.oms.common.OrderAPIClient;
import com.shafaat.oms.dto.OrderDTO;
import com.shafaat.oms.dto.OrderItemDTO;
import com.shafaat.oms.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private OrderAPIClient orderAPIClient;

    @GetMapping("/orders/{orderId}/items")
    public List<OrderItemDTO> getAllItems(@PathVariable(value = "orderId") Integer orderId){

        OrderDTO dto = orderAPIClient.getOrder(orderId);
        if(dto!=null){
            return orderItemService.findByOrderId(orderId);
        }else{
            throw new OrderNotFoundException("Order not found for OrderId " + orderId );
        }
    }

    @PostMapping("/orders/{orderId}/items")
    public OrderItemDTO addItemToOrder(@PathVariable(value = "orderId") Integer orderId,
                                       @RequestBody @Valid OrderItemDTO itemDTO){

        OrderDTO dto = orderAPIClient.getOrder(orderId);
        if(dto!=null){
            return orderItemService.addItemToOrder(orderId, itemDTO);
        }else{
            throw new OrderNotFoundException("Order not found for OrderId " + orderId );
        }

    }


}
