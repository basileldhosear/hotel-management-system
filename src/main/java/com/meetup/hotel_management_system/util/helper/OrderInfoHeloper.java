package com.meetup.hotel_management_system.util.helper;

import com.meetup.hotel_management_system.dto.OrderInfoDto;
import com.meetup.hotel_management_system.repository.entity.OrderInfoEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrderInfoHeloper {

    public static OrderInfoEntity mapToEntity(OrderInfoDto orderInfoDto) {

        return OrderInfoEntity.builder()
                .customerName(orderInfoDto.getCustomerName())
                .status(orderInfoDto.getStatus())
                .build();
    }

    public static OrderInfoDto mapToDto(OrderInfoEntity orderInfoEntity) {

        return OrderInfoDto.builder()
                .customerName(orderInfoEntity.getCustomerName())
                .status(orderInfoEntity.getStatus())
                .build();
    }


}

