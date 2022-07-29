package com.meetup.hotel_management_system.controller;

import com.meetup.hotel_management_system.constant.HmsConstants;
import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.repository.entity.OrderEntity;
import com.meetup.hotel_management_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Secured({HmsConstants.ROLE_MANAGER, HmsConstants.ROLE_STAFF})
    @PostMapping
    public OrderDto createOrder(@RequestBody OrderDto orderDto){
        return orderService.saveOrder(orderDto);

    }



}
