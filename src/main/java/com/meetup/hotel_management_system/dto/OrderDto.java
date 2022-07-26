package com.meetup.hotel_management_system.dto;

import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int quantity;
    private String description;

    private MenuDto menu;

}
