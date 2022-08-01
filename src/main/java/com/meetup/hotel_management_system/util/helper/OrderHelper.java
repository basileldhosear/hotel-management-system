package com.meetup.hotel_management_system.util.helper;


import com.meetup.hotel_management_system.dto.MenuDetailsDto;
import com.meetup.hotel_management_system.dto.MenuDto;
import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import com.meetup.hotel_management_system.repository.entity.OrderEntity;
import com.meetup.hotel_management_system.repository.entity.OrderInfoEntity;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;


@UtilityClass
public class OrderHelper {

    public static OrderEntity mapToEntity(OrderDto orderDto) {

        if(orderDto != null){
        return OrderEntity.builder()
                .quantity(orderDto.getQuantity())
                .status(orderDto.getStatus())

//                .menu(orderDto.getMenu().stream()
//                        .map(MenuHelper::mapToEntity)
//                        .collect(Collectors.toList()))

                //new
//

                .build();
    }return null;
    }


//    public static OrderDto mapToDto(OrderEntity orderEntity) {
//
//        if(orderEntity != null)
//        {
//        return OrderDto.builder()
//                .id(orderEntity.getId())
//                .orderInfo(OrderInfoHelper.mapToDto(orderEntity.getOrderInfo()))
//
////                .menu(orderEntity.getMenu().stream()
////                        .map(MenuHelper::mapToDto)
////                        .collect(Collectors.toList()))
//
//                .quantity(orderEntity.getQuantity())
//                .description(orderEntity.getDescription())
//                .status(orderEntity.getStatus())
//
//                //new
//                .menu(MenuHelper.mapToDto(orderEntity.getMenu()))
//
//                .build();
//    }return null;
//    }

    public OrderEntity mapToOrderEntityFromMenuDetails(MenuDetailsDto menuDetailsDto, OrderInfoEntity orderInfoEntity,String orderDetailStatus){

        if(menuDetailsDto!=null){

            return OrderEntity.builder()
                    .orderInfo(orderInfoEntity)
                    .menu(MenuEntity.builder()
                            .id(menuDetailsDto.getMenuId())
                            .build())
                    .status(orderDetailStatus)
                    .quantity(menuDetailsDto.getQuantity())
                    .description(menuDetailsDto.getDescription())
                    .build();
        }
        return null;
    }

}
