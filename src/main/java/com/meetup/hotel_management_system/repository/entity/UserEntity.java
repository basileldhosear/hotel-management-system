package com.meetup.hotel_management_system.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "user")
@Builder
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username", unique = true, nullable = false)
    private String userName;
    @Column(name = "passwd", nullable = false)
    private String passwd;
    private boolean active;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="role_id", referencedColumnName = "id")
    private RoleEntity role;

//    @OneToMany(mappedBy = "staff")
//    List<OrderInfoEntity> orderInfoEntities;








//    private Set<Role> role = new HashSet<>();
//
//
//    public void addRole(Role role)
//    {
//        this.role.add(role);
//    }

}
