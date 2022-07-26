package com.meetup.hotel_management_system.util.helper;

import com.meetup.hotel_management_system.dto.UserDto;
import com.meetup.hotel_management_system.repository.entity.UserEntity;
import lombok.experimental.UtilityClass;

import java.util.HashSet;

@UtilityClass
public class UserHelper {

    public static UserEntity mapToEntity(UserDto userDto) {

        return UserEntity.builder()
                .userName(userDto.getUsername())
                .passwd(userDto.getPassword())
                .role(RoleHelper.mapToEntity(userDto.getRole()))
                .build();

    }

    public static UserDto mapToDto(UserEntity userEntity) {

        return UserDto.builder()
                .username(userEntity.getUserName())
                .password(userEntity.getPasswd())
                .role(RoleHelper.mapToDto(userEntity.getRole()))
                .build();

    }
}
