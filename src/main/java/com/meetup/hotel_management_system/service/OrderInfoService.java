package com.meetup.hotel_management_system.service;


import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.dto.OrderInfoDto;

public interface OrderInfoService {

    OrderInfoDto saveOrderInfo(OrderInfoDto orderInfoDto);

}
