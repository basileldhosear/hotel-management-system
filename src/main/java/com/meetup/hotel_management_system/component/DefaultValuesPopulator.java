package com.meetup.hotel_management_system.component;

import com.meetup.hotel_management_system.dto.MenuDto;
import com.meetup.hotel_management_system.dto.RoleDto;
import com.meetup.hotel_management_system.dto.UserDto;
import com.meetup.hotel_management_system.repository.MenuRepository;
import com.meetup.hotel_management_system.repository.RoleRepository;
import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import com.meetup.hotel_management_system.repository.entity.RoleEnum;
import com.meetup.hotel_management_system.service.MenuService;
import com.meetup.hotel_management_system.service.RoleService;
import com.meetup.hotel_management_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class DefaultValuesPopulator {

    @Autowired
    private final MenuRepository menuRepository;

    @Autowired
    private final MenuService menuService;

    @Autowired
    private final RoleService roleService;

    @Autowired
    private final UserService userService;

  private final RoleRepository roleRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void afterStartup() {

        RoleEntity manager = RoleEntity.builder()
                .name(RoleEnum.MANAGER.toString())
                .build();
        RoleEntity staff = RoleEntity.builder()
                .name(RoleEnum.STAFF.toString())
                .build();
        RoleEntity guest =RoleEntity.builder()
                .name(RoleEnum.GUEST.toString())
                .build();
        roleService.saveAll(List.of(manager,staff,guest));

        userService.createUser(new UserDto(1,"basil", "basil", RoleDto.builder()
                .roleId(1)
                .build()));




        menuRepository.save(MenuEntity.builder()
                .name("dosa")
                .type("breakfast")
                .price(50)
                .available(true)
                .build());


        MenuEntity menuTwo=new MenuEntity();
        menuTwo.setName("vada");
        menuTwo.setType("snacks");
        menuTwo.setPrice(20);
        menuTwo.setAvailable(true);
        menuService.save(menuTwo);



//
//        MenuEntity menuOne=new MenuEntity();
//        menuOne.setName("dosa");
//        menuOne.setType("breakfast");
//        menuOne.setPrice(50);
//        menuOne.setAvailable(true);
//        menuRepository.save(menuOne);

//        menuRepository.save(MenuEntity.builder()
//                        .name("dosa")
//                        .type("breakfast")
//                        .price(50)
//                        .available(true)
//                .build());



    }
}
