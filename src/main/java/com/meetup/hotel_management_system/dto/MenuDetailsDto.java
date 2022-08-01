package com.meetup.hotel_management_system.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class MenuDetailsDto {

    private int menuId;
    private int quantity;
    private String description;
}
