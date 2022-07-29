package com.meetup.hotel_management_system.service.impl;

import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.repository.OrderRepository;

import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import com.meetup.hotel_management_system.repository.entity.OrderEntity;
import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import com.meetup.hotel_management_system.service.OrderService;
import com.meetup.hotel_management_system.util.helper.OrderHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl  implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {


        return OrderHelper.mapToDto(orderRepository.saveAndFlush(OrderHelper.mapToEntity(orderDto)));


    }




}
