package com.meetup.hotel_management_system.service.impl;

import com.meetup.hotel_management_system.dto.MenuDto;
import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.dto.UserDto;
import com.meetup.hotel_management_system.repository.OrderRepository;
import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import com.meetup.hotel_management_system.repository.entity.OrderEntity;
import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import com.meetup.hotel_management_system.repository.entity.UserEntity;
import com.meetup.hotel_management_system.service.OrderService;
import com.meetup.hotel_management_system.util.helper.MenuHelper;
import com.meetup.hotel_management_system.util.helper.OrderHelper;
import com.meetup.hotel_management_system.util.helper.UserHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl  implements OrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDto saveOrder(OrderDto orderDto) {
//no
//        MenuEntity menuEntity= orderRepository.findById(orderDto.getMenu().getName());
//        OrderEntity orderEntity = OrderHelper.mapToEntity(orderDto);
        return OrderHelper.mapToDto(orderRepository.saveAndFlush(OrderHelper.mapToEntity(orderDto)));
    }



// //no
//    @Override
//    public boolean createUser(UserDto userDto) {
//
//        RoleEntity roleEntity=roleRepository.findById(userDto.getRole().getRoleId()).get();
//
//        UserEntity userEntity = UserHelper.mapToEntity(userDto);
//        userEntity.setPasswd(passwordEncoder.encode(userEntity.getPasswd()));
//        userEntity.setRole(roleEntity);
//        userEntity.setActive(true);
//
//        userRepository.save(userEntity);
//        return true;
//    }


}
