package com.meetup.hotel_management_system.controller;

import com.meetup.hotel_management_system.constant.HmsConstants;
import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.dto.UserDto;
import com.meetup.hotel_management_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Secured({HmsConstants.ROLE_MANAGER, HmsConstants.ROLE_STAFF})
    @PostMapping
    public OrderDto createOrder(OrderDto orderDto){
        return orderService.saveOrder(orderDto);

    }

    //no
//    @PostMapping
//    @Secured(HmsConstants.ROLE_MANAGER)
//    public String createUser(@RequestBody UserDto userDto) {
//        userService.createUser(userDto);
//        return String.format("User with username %s was created and assigned role %s",
//                userDto.getUsername()
//                ,userDto.getRole().getName()
//        );
//    }



}
