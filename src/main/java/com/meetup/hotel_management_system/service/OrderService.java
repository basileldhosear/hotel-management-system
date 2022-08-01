package com.meetup.hotel_management_system.service;


import com.meetup.hotel_management_system.dto.OrderDto;

public interface OrderService {

    OrderDto saveOrder(OrderDto orderDto);

}
