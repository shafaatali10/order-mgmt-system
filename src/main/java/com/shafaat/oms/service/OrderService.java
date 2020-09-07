package com.shafaat.oms.service;

import com.shafaat.oms.dto.OrderDTO;
import com.shafaat.oms.entity.Order;
import com.shafaat.oms.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {


    @Autowired
    private OrderRepo orderRepo;

    public OrderDTO createOrder(OrderDTO orderDTO){
        Order order = _convertDtoToEntity(orderDTO);
        orderRepo.save(order);
        orderDTO.setOrderId(order.getOrderId());
        return orderDTO;
    }

    private Order _convertDtoToEntity(OrderDTO orderDTO){
        if(orderDTO!=null){
            Order order = new Order();
            order.setCustomerName(orderDTO.getCustomerName());
            order.setOrderDate(orderDTO.getOrderDate());
            order.setOrderItems(orderDTO.getOrderItems());
            order.setShippingAddress(orderDTO.getShippingAddress());
            order.setTotal(orderDTO.getTotal());
            return order;
        }
        return null;
    }

    private OrderDTO _convertEntityToOrder(Order order){
        if(order!=null){
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setCustomerName(order.getCustomerName());
            orderDTO.setOrderDate(order.getOrderDate());
            orderDTO.setOrderItems(order.getOrderItems());
            orderDTO.setShippingAddress(order.getShippingAddress());
            orderDTO.setTotal(order.getTotal());
            orderDTO.setOrderId(order.getOrderId());
            return orderDTO;
        }
        return null;
    }

    public OrderDTO getOrder(Integer orderId){
        return _convertEntityToOrder(orderRepo.findById(orderId).orElse(null));
    }

    public List<OrderDTO> listOrders(){
        List<Order> orders=orderRepo.findAll();
        List<OrderDTO> returnOrders=new ArrayList<OrderDTO>();

        for(Order o: orders){
            OrderDTO temp = _convertEntityToOrder(o);
            returnOrders.add(temp);
        }
        return returnOrders;
    }

}
