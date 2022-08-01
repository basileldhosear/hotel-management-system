package com.meetup.hotel_management_system.dto;

import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int userId;
    private String username;
    private String password;

    private RoleDto role;
}
