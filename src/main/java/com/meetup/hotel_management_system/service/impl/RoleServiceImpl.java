package com.meetup.hotel_management_system.service.impl;

import com.meetup.hotel_management_system.repository.RoleRepository;
import com.meetup.hotel_management_system.repository.UserRepository;
import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import com.meetup.hotel_management_system.repository.entity.UserEntity;
import com.meetup.hotel_management_system.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;


    private final UserRepository userRepository;

    @Override
    public RoleEntity createNewRole(RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }




}
