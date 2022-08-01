package com.meetup.hotel_management_system.controller;

import com.meetup.hotel_management_system.constant.HmsConstants;
import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.exception.BusinessException;
import com.meetup.hotel_management_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Secured({HmsConstants.ROLE_MANAGER, HmsConstants.ROLE_STAFF})
    @PostMapping
    public String createOrder(@RequestBody OrderDto orderDto) throws BusinessException {
        orderService.saveOrder(orderDto);
        return "order saved";

    }



}
