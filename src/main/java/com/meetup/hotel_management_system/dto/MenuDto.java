package com.meetup.hotel_management_system.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuDto {

    private String name;
    private String type;
    private int price;
    private boolean available;

}
