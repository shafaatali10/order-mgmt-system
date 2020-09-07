package com.shafaat.oms.service;

import com.shafaat.oms.dto.OrderDTO;
import com.shafaat.oms.dto.OrderItemDTO;
import com.shafaat.oms.entity.Order;
import com.shafaat.oms.entity.OrderItem;
import com.shafaat.oms.repo.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepo repo;

    public OrderItemDTO addOrderItem(OrderItemDTO orderItemDTO){
        OrderItem item = _convertDtoToEntity(orderItemDTO);
        repo.save(item);
        orderItemDTO.setOrderItemId(item.getOrderItemId());
        return orderItemDTO;
    }

    private OrderItem _convertDtoToEntity(OrderItemDTO dto){
        if(dto!=null){
            OrderItem order = new OrderItem();
            order.setQuantity(dto.getQuantity());
            order.setProductName(dto.getProductName());
            order.setProductCode(dto.getProductCode());
            order.setOrderId(dto.getOrderId());
            return order;
        }
        return null;
    }

    private OrderItemDTO _convertEntityToDto(OrderItem item){
        if(item!=null){
            OrderItemDTO itemDto = new OrderItemDTO();
            itemDto.setQuantity(item.getQuantity());
            itemDto.setProductName(item.getProductName());
            itemDto.setProductCode(item.getProductCode());
            itemDto.setOrderId(item.getOrderId());
            itemDto.setOrderItemId(item.getOrderItemId());
            return itemDto;
        }
        return null;
    }

    public OrderItemDTO getOrderItem(Integer orderItemId){
        return _convertEntityToDto(repo.findById(orderItemId).get());
    }

    public List<OrderItemDTO> findByOrderId(Integer orderId){
        List<OrderItem> orderItems=repo.findByOrderId(orderId);
        List<OrderItemDTO> returnOrderItems=new ArrayList<OrderItemDTO>();

        for(OrderItem o: orderItems){
            OrderItemDTO temp = _convertEntityToDto(o);
            returnOrderItems.add(temp);
        }
        return returnOrderItems;
    }

    public OrderItemDTO addItemToOrder(Integer orderId, OrderItemDTO itemDTO) {
        itemDTO.setOrderId(orderId);

        OrderItem item = _convertDtoToEntity(itemDTO);
        repo.save(item);
        itemDTO.setOrderItemId(item.getOrderItemId());
        return itemDTO;


    }
}
