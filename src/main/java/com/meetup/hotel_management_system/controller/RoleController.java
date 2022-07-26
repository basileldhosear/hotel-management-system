package com.meetup.hotel_management_system.controller;

import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import com.meetup.hotel_management_system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;


    @PermitAll
    @PostMapping({"/role"})
    public RoleEntity createNewRole(@RequestBody RoleEntity roleEntity)
    {
        return roleService.createNewRole(roleEntity);
    }



}
