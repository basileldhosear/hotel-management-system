package com.meetup.hotel_management_system.service;


import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.exception.BusinessException;
import com.meetup.hotel_management_system.repository.entity.OrderEntity;

public interface OrderService {

    OrderDto saveOrder(OrderDto orderDto) throws BusinessException;




}
