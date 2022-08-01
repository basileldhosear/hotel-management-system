package com.meetup.hotel_management_system.util.helper;

import com.meetup.hotel_management_system.dto.UserDto;
import com.meetup.hotel_management_system.repository.entity.UserEntity;
import lombok.experimental.UtilityClass;

import java.util.HashSet;

@UtilityClass
public class UserHelper {

    public static UserEntity mapToEntity(UserDto userDto) {

        if (userDto!=null){
        return UserEntity.builder()
                .id(userDto.getUserId())
                .userName(userDto.getUsername())
                .passwd(userDto.getPassword())
                .role(RoleHelper.mapToEntity(userDto.getRole()))
                .build();
        }return null;
    }

    public static UserDto mapToDto(UserEntity userEntity) {

        if (userEntity!=null) {
        return UserDto.builder()
                .userId(userEntity.getId())
                .username(userEntity.getUserName())
                .password(userEntity.getPasswd())
                .role(RoleHelper.mapToDto(userEntity.getRole()))
                .build();
        }return null;

    }
}
