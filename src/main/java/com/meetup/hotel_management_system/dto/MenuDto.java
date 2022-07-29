package com.meetup.hotel_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuDto {

    private int id;
    private String name;
    private String type;
    private int price;
    private boolean available;


}
