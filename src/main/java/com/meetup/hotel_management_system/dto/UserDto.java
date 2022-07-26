package com.meetup.hotel_management_system.dto;

import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class UserDto {

    private String username;
    private String password;

    private RoleDto role;
}
