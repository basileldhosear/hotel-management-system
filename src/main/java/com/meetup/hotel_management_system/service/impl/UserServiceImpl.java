package com.meetup.hotel_management_system.service.impl;

import com.meetup.hotel_management_system.dto.LoginDto;
import com.meetup.hotel_management_system.dto.UserDto;
import com.meetup.hotel_management_system.exception.ResourceNotFoundException;
import com.meetup.hotel_management_system.repository.RoleRepository;
import com.meetup.hotel_management_system.repository.UserRepository;
import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import com.meetup.hotel_management_system.repository.entity.UserEntity;
import com.meetup.hotel_management_system.service.UserService;
import com.meetup.hotel_management_system.util.helper.UserHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;


    @Override
    public boolean createUser(UserDto userDto) {

        RoleEntity roleEntity=roleRepository.findById(userDto.getRole().getRoleId()).get();

        UserEntity userEntity = UserHelper.mapToEntity(userDto);
        userEntity.setPasswd(passwordEncoder.encode(userEntity.getPasswd()));
        userEntity.setRole(roleEntity);
        userEntity.setActive(true);

        userRepository.save(userEntity);
        return true;
    }

    @Override
    public List<UserDto> getAll() {

        return userRepository.findAll().stream()
                .map(UserHelper::mapToDto)
                .peek(userDto -> userDto.setPassword(null))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto validateAndGetUser(LoginDto loginDto) {

        var existingUserEntityOptional = userRepository.
                findByUserNameAndActiveTrue(loginDto.getUsername());

        if (existingUserEntityOptional.isPresent()) {

            if (passwordEncoder.matches(loginDto.getPassword(), existingUserEntityOptional.get().getPasswd())) {

                return UserHelper.mapToDto(existingUserEntityOptional.get());
            }
        }

        return null;
    }

    @Override
    public UserDto getByUserName(String userName) throws ResourceNotFoundException {
        var userEntityOptional = userRepository.findByUserName(userName);

        return userEntityOptional.map(UserHelper::mapToDto)
                .orElseThrow(
                        () -> new ResourceNotFoundException(String.format("user not found %s",userName)));

        //old
        //.orElse(null);

    }

    //
    //

    @Override
    public String deleteByUserId(int userId) throws ResourceNotFoundException {

        userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("User not found",userId)));

        userRepository.deleteById(userId);
        return "User Deleted successfully";

    }




}
