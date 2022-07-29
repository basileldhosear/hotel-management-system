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
    private int tblNo;
    private String customerName;
    private String status;



//    @OneToOne(mappedBy = "orderInfo")
//    private OrderEntity orderInfo;
//
//
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JoinColumn(name="staff_id", referencedColumnName = "id")
//    private UserEntity staff;




}
