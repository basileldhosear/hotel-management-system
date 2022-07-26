package com.meetup.hotel_management_system.repository;

import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {

    RoleEntity findByName(String role);
}
