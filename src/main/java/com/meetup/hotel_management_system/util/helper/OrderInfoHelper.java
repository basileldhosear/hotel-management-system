package com.meetup.hotel_management_system.util.helper;

import com.meetup.hotel_management_system.dto.OrderInfoDto;
import com.meetup.hotel_management_system.repository.entity.OrderInfoEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrderInfoHelper {

    public static OrderInfoEntity mapToEntity(OrderInfoDto orderInfoDto) {

        return OrderInfoEntity.builder()
                .id(orderInfoDto.getId())
                .tblNo(orderInfoDto.getTblNo())
                .customerName(orderInfoDto.getCustomerName())
                .status(orderInfoDto.getStatus())
                .build();
    }

    public static OrderInfoDto mapToDto(OrderInfoEntity orderInfoEntity) {

        return OrderInfoDto.builder()
                .id(orderInfoEntity.getId())
                .tblNo(orderInfoEntity.getTblNo())
                .customerName(orderInfoEntity.getCustomerName())
                .status(orderInfoEntity.getStatus())
                .build();
    }


}

