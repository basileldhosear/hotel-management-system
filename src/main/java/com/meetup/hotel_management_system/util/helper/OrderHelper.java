package com.meetup.hotel_management_system.util.helper;


import com.meetup.hotel_management_system.dto.MenuDto;
import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import com.meetup.hotel_management_system.repository.entity.OrderEntity;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;


@UtilityClass
public class OrderHelper {

    public static OrderEntity mapToEntity(OrderDto orderDto) {

        if(orderDto != null){
        return OrderEntity.builder()
                .id(orderDto.getId())
                .quantity(orderDto.getQuantity())
                .description(orderDto.getDescription())
                .status(orderDto.getStatus())
                .orderInfo(OrderInfoHelper.mapToEntity(orderDto.getOrderInfo()))

                //new
//                .menu(MenuHelper.mapToEntity(orderDto.getMenu()))
//

//                .menu(orderDto.getMenu().stream()
//                        .map(MenuHelper::mapToEntity)
//                        .collect(Collectors.toList()))
                .build();
    }return null;
    }


    public static OrderDto mapToDto(OrderEntity orderEntity) {

        if(orderEntity != null)
        {
        return OrderDto.builder()
                .id(orderEntity.getId())
                .orderInfo(OrderInfoHelper.mapToDto(orderEntity.getOrderInfo()))

                //new
//                .menu(MenuHelper.mapToDto(orderEntity.getMenu()))

//                .menu(orderEntity.getMenu().stream()
//                        .map(MenuHelper::mapToDto)
//                        .collect(Collectors.toList()))
                .quantity(orderEntity.getQuantity())
                .description(orderEntity.getDescription())
                .status(orderEntity.getStatus())
                .build();
    }return null;
    }
}
