package com.meetup.hotel_management_system.service;

import com.meetup.hotel_management_system.dto.MenuDto;
import com.meetup.hotel_management_system.repository.entity.MenuEntity;

import java.util.List;

public interface MenuService {

    MenuDto saveMenu(MenuDto menuDto);

    List<MenuDto> getAllMenus();

    List<MenuDto> getAllMenuLikeName(String menuName);

    List<MenuDto> searchAll(String keyword);

    String deleteByMenuId(int menuId);

    Boolean deleteByMenuName(String menuName);

    //
    //

    MenuEntity updateMenu(MenuEntity menuEntity);
    List<MenuEntity> getAllMenusPaging(Integer pageNo, Integer pageSize, String sortBy);

    void save(MenuEntity menu);
}
