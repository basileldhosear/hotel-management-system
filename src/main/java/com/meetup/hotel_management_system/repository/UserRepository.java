package com.meetup.hotel_management_system.repository;

import com.meetup.hotel_management_system.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUserName(String userName);

    Optional<UserEntity> findByUserNameAndActiveTrue(String userName);


//    List<Object> findByUserName(String name);
}
