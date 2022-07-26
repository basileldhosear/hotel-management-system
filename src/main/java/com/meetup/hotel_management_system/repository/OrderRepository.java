package com.meetup.hotel_management_system.repository;

import com.meetup.hotel_management_system.repository.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer> {

}
