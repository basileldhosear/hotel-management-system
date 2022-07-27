package com.meetup.hotel_management_system.repository;

import com.meetup.hotel_management_system.repository.entity.OrderInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInfoRepository extends JpaRepository<OrderInfoEntity,Integer> {


}
