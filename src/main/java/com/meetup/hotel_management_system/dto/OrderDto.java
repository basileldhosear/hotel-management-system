package com.meetup.hotel_management_system.dto;


import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

    private int orderInfoId;
    private int quantity;
    private int tableNo;
    private int staffId;
    private String customerName;
    private String status;
    List<MenuDetailsDto> menuDetails;


}
