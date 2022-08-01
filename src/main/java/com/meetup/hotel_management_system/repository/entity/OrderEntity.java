package com.meetup.hotel_management_system.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_details")
@Builder
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "quantity", nullable = false)
    private int quantity;
    private String description;
    private String status;


    //orderInfo into order details
    @OneToOne
    @JoinColumn(name = "orderInfo_id",referencedColumnName = "id")
    private OrderInfoEntity orderInfo;



    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    private MenuEntity menu;



//    //menu id mapping to order table
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "menu_id", referencedColumnName = "id")
//    MenuEntity menu;
//




//
//







}
