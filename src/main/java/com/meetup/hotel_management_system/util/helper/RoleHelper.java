package com.meetup.hotel_management_system.util.helper;


import com.meetup.hotel_management_system.dto.RoleDto;
import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import com.meetup.hotel_management_system.repository.entity.UserEntity;
import lombok.experimental.UtilityClass;


@UtilityClass
public class RoleHelper {


    public static RoleDto mapToDto(RoleEntity roleEntity) {

        if (roleEntity != null) {
            return RoleDto.builder()
                    .roleId(roleEntity.getId())
                    .name(roleEntity.getName())
                    .build();
        }
        return null;
    }

    public static RoleEntity mapToEntity(RoleDto roleDto) {

        if (roleDto != null) {
            return RoleEntity.builder()
                    .name(roleDto.getName())
                    .build();
        }
        return null;
    }
}

