package com.meetup.hotel_management_system.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_info")
@Builder
public class OrderInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@Column(unique = true, nullable = false)
    private int tblNo;
    private String customerName;
    private String status;


   // Map staffId into orderInfo table
    @OneToOne
    @JoinColumn(name = "staff_id",referencedColumnName = "id")
    private UserEntity staff;


//    @OneToOne(mappedBy = "orderInfo")
//    private OrderEntity order;






}
