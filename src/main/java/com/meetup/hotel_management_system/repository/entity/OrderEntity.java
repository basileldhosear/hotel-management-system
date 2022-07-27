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


//    @OneToMany(mappedBy = "order")
//    List<MenuEntity> order;


    //new
    @OneToMany(mappedBy = "order")
    List<MenuEntity> menu;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderinfo_id", referencedColumnName = "id")
    private OrderInfoEntity orderInfo;



}
