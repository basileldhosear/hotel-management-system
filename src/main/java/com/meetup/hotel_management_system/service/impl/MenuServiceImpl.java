package com.meetup.hotel_management_system.service.impl;

import com.meetup.hotel_management_system.dto.MenuDto;
import com.meetup.hotel_management_system.exception.BusinessException;
import com.meetup.hotel_management_system.exception.ResourceNotFoundException;
import com.meetup.hotel_management_system.repository.MenuRepository;
import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import com.meetup.hotel_management_system.service.MenuService;
import com.meetup.hotel_management_system.util.helper.MenuHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;



    @Override
    public void save(MenuEntity menu) {
        menuRepository.save(menu);
    }


    @Override
    public MenuDto saveMenu(MenuDto menuDto) {

        return MenuHelper.mapToDto(menuRepository.saveAndFlush(MenuHelper.mapToEntity(menuDto)));
    }

    @Override
    public List<MenuDto> getAllMenus() {
        return menuRepository.findAll()
                .stream()
                .map(MenuHelper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuDto> getAllMenuLikeName(String menuName) {
        return menuRepository.findMenuByFoodName(menuName).stream()
                .map(MenuHelper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuDto> searchAll(String keyword) {
        return menuRepository.search(keyword).stream()
                .map(MenuHelper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public String deleteByMenuId(int menuId) throws ResourceNotFoundException {

    var menuEntity= menuRepository.findById(menuId).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Menu not found for id %s",menuId)));

        System.out.println(menuEntity);

       menuRepository.deleteById(menuId);
        return "Menu Deleted successfully";
    }

    @Override
    public Boolean deleteByMenuName(String menuName) {

//        MenuDto menu = (MenuDto) menuRepository.findMenuByFoodName(menuName);
//        if(menu == null){
//            throw new ResourceNotFoundException("menu",menuName,1);
//        }

        menuRepository.deleteByName(menuName);
        return true;
    }


//
//

    public MenuEntity updateMenu(MenuEntity menuEntity) {
        MenuEntity existing = menuRepository.findById(menuEntity.getId()).orElse(null);
        existing.setName(menuEntity.getName());
        existing.setType(menuEntity.getType());
        existing.setPrice(menuEntity.getPrice());
        existing.setAvailable(menuEntity.isAvailable());
        return menuRepository.save(existing);
    }
//
//
    public List<MenuEntity> getAllMenusPaging(Integer pageNo, Integer pageSize, String sortBy) {
        PageRequest paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<MenuEntity> pagedResult = menuRepository.findAll(paging);


        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<MenuEntity>();
        }
    }



}
