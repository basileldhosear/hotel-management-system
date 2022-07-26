package com.meetup.hotel_management_system.repository;

import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {


    @Query("SELECT m FROM MenuEntity m WHERE m.name LIKE %?1%"
            + " OR m.type LIKE %?1%"
            + " OR m.available LIKE %?1%"
            + " OR m.id LIKE %?1%"
            //+ " OR m.price LIKE %?1%"
            + " OR CONCAT(m.price, '') LIKE %?1%"
    )
    List<MenuEntity> search(String keyword);

    void deleteByName(String name);

    @Query("SELECT m FROM MenuEntity m WHERE m.name LIKE %?1%")
    List<MenuEntity> findMenuByFoodName(String foodName);
}


