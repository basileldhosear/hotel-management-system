package com.meetup.hotel_management_system.util.helper;


import com.meetup.hotel_management_system.dto.MenuDto;
import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import com.meetup.hotel_management_system.repository.entity.OrderEntity;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Set;

@UtilityClass
public class OrderHelper {

    public static OrderEntity mapToEntity(OrderDto orderDto) {

        return OrderEntity.builder()
                //.order((List<MenuEntity>) orderDto.getMenu())
                .quantity(orderDto.getQuantity())
                .description(orderDto.getDescription())

               // .role(RoleHelper.mapToEntity(userDto.getRole()))
                .build();
    }

    public static OrderDto mapToDto(OrderEntity orderEntity) {

        return OrderDto.builder()

                .quantity(orderEntity.getQuantity())
                .description(orderEntity.getDescription())
                .build();
    }
}
