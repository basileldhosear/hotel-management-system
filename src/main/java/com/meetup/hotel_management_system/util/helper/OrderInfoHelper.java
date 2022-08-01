package com.meetup.hotel_management_system.util.helper;

import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.dto.OrderInfoDto;
import com.meetup.hotel_management_system.repository.entity.OrderInfoEntity;
import com.meetup.hotel_management_system.repository.entity.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class OrderInfoHelper {

    public static OrderInfoEntity mapToEntity(OrderInfoDto orderInfoDto) {

        if (orderInfoDto != null) {
            return OrderInfoEntity.builder()
                    .id(orderInfoDto.getId())
                    .tblNo(orderInfoDto.getTblNo())
                    .customerName(orderInfoDto.getCustomerName())
                    .status(orderInfoDto.getStatus())
                    .staff((UserHelper.mapToEntity(orderInfoDto.getStaff())))

                    .build();
        }return null;
    }





    public static OrderInfoDto mapToDto(OrderInfoEntity orderInfoEntity) {

        if (orderInfoEntity != null) {
            return OrderInfoDto.builder()
                    .id(orderInfoEntity.getId())
                    .tblNo(orderInfoEntity.getTblNo())
                    .customerName(orderInfoEntity.getCustomerName())
                    .status(orderInfoEntity.getStatus())
                    .staff(UserHelper.mapToDto(orderInfoEntity.getStaff()))
                    .build();
        }return null;
    }


    public static OrderInfoEntity mapToEntityFromOrder(OrderDto orderDto){

        if(orderDto!=null){

            return OrderInfoEntity.builder()
                    .staff(UserEntity.builder()
                            .id(orderDto.getStaffId())
                            .build())
                    .tblNo(orderDto.getTableNo())
                    .customerName(orderDto.getCustomerName())
                    .build();
        }

        return null;
    }

}

