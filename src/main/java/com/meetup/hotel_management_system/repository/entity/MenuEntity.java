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


    //menu id mapping to order table
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "menu", fetch = FetchType.LAZY)
    private OrderEntity order;



//    @ManyToOne(fetch = FetchType.EAGER)
//    private OrderEntity order;








}
