package com.meetup.hotel_management_system.util.helper;


import com.meetup.hotel_management_system.dto.RoleDto;
import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import lombok.experimental.UtilityClass;


@UtilityClass
public class RoleHelper {



    public static RoleDto mapToDto(RoleEntity roleEntity){

        return RoleDto.builder()
                .roleId(roleEntity.getId())
                .name(roleEntity.getName())
                .build();
    }

    public static RoleEntity mapToEntity(RoleDto roleDto){

        return RoleEntity.builder()
//                .role(roleDto.getRoleId())
                .name(roleDto.getName())
                .build();
    }
}

