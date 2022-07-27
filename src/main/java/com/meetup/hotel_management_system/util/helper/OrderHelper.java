package com.meetup.hotel_management_system.util.helper;


import com.meetup.hotel_management_system.dto.MenuDto;
import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.repository.entity.OrderEntity;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;


@UtilityClass
public class OrderHelper {

    public static OrderEntity mapToEntity(OrderDto orderDto) {

        return OrderEntity.builder()
                //.order((List<MenuEntity>) orderDto.getMenu())
                .quantity(orderDto.getQuantity())
                .description(orderDto.getDescription())
                .build();
    }

    public static OrderDto mapToDto(OrderEntity orderEntity) {

        return OrderDto.builder()
                .menu(orderEntity.getMenu().stream()
                        .map(MenuHelper::mapToDto)
                        .collect(Collectors.toList()))
                .quantity(orderEntity.getQuantity())
                .description(orderEntity.getDescription())
                .build();
    }
}
