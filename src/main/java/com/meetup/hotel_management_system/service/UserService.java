package com.meetup.hotel_management_system.service;

import com.meetup.hotel_management_system.dto.LoginDto;
import com.meetup.hotel_management_system.dto.UserDto;

import java.util.List;

public interface UserService {



    boolean createUser(UserDto userDto);

    List<UserDto> getAll();

    UserDto validateAndGetUser(LoginDto loginDto);

    UserDto getByUserName(String userName);


    String deleteByUserId(int userId);

}
