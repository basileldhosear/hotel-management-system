package com.meetup.hotel_management_system.service;

import com.meetup.hotel_management_system.repository.entity.RoleEntity;

import java.util.List;

public interface RoleService {

   RoleEntity createNewRole(RoleEntity roleEntity);


    List<RoleEntity> saveAll(List<RoleEntity> role);
}
