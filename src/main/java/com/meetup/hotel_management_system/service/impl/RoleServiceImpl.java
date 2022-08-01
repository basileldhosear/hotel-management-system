package com.meetup.hotel_management_system.service.impl;

import com.meetup.hotel_management_system.repository.RoleRepository;
import com.meetup.hotel_management_system.repository.UserRepository;
import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import com.meetup.hotel_management_system.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<RoleEntity> saveAll(List<RoleEntity> role) {
        return roleRepository.saveAllAndFlush(role);
    }




}
