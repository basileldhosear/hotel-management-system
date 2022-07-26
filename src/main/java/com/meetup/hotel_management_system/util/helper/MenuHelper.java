package com.meetup.hotel_management_system.util.helper;

import com.meetup.hotel_management_system.dto.MenuDto;
import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MenuHelper {


    public static MenuEntity mapToEntity(MenuDto menuDto) {

        return MenuEntity.builder()
                .name(menuDto.getName())
                .type(menuDto.getType())
                .price(menuDto.getPrice())
                .available(menuDto.isAvailable())

                .build();
    }

    public static MenuDto mapToDto(MenuEntity menuEntity) {

        return MenuDto.builder()
                .name(menuEntity.getName())
                .type(menuEntity.getType())
                .price(menuEntity.getPrice())
                .available(menuEntity.isAvailable())
                .build();
    }
}
