package com.meetup.hotel_management_system.service;


import com.meetup.hotel_management_system.dto.MenuDto;
import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.dto.UserDto;

public interface OrderService {

    OrderDto saveOrder(OrderDto orderDto);

    //no
//    boolean createUser(UserDto userDto);

}
