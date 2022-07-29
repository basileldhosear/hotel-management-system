package com.meetup.hotel_management_system.component;

import com.meetup.hotel_management_system.dto.MenuDto;
import com.meetup.hotel_management_system.dto.RoleDto;
import com.meetup.hotel_management_system.dto.UserDto;
import com.meetup.hotel_management_system.repository.RoleRepository;
import com.meetup.hotel_management_system.repository.entity.RoleEntity;
import com.meetup.hotel_management_system.repository.entity.RoleEnum;
import com.meetup.hotel_management_system.service.MenuService;
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
    private final MenuService menuService;

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
        roleRepository.saveAll(List.of(manager,staff,guest));

        userService.createUser(new UserDto("basil", "basil", RoleDto.builder()
                .roleId(1)
                .build()));


//        menuService.saveMenu(new MenuDto("1","dosa","breakfast","50","true",
//                MenuDto.builder().build()));



    }
}
