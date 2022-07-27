package com.meetup.hotel_management_system.dto;


import lombok.*;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int id;
    private int quantity;
    private String description;

    private List<MenuDto> menu;

}
