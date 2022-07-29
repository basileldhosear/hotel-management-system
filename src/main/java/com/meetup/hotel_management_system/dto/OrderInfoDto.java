package com.meetup.hotel_management_system.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoDto {

    private int id;
    private int tblNo;
    private String customerName;
    private String status;

}
