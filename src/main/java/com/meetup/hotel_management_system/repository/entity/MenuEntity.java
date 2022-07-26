package com.meetup.hotel_management_system.repository.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "menu")
@Builder
public class MenuEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String name;
    private String type;
    private int price;
    private boolean available;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="order_id", referencedColumnName = "id")
    private OrderEntity order;







}
