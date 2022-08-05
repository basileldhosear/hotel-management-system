package com.meetup.hotel_management_system.repository;

import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import com.meetup.hotel_management_system.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

    List<Object> findById(String name);


}
