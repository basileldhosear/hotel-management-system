package com.meetup.hotel_management_system.controller;

import com.meetup.hotel_management_system.constant.HmsConstants;
import com.meetup.hotel_management_system.dto.MenuDto;
import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import com.meetup.hotel_management_system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @Secured({HmsConstants.ROLE_MANAGER, HmsConstants.ROLE_STAFF})
    @PostMapping
    public MenuDto addMenu(@RequestBody MenuDto menuDto) {

        return menuService.saveMenu(menuDto);
    }

    @Secured({HmsConstants.ROLE_MANAGER, HmsConstants.ROLE_STAFF, HmsConstants.ROLE_GUEST})
    @GetMapping
    public List<MenuDto> getAllMenus() {

        return menuService.getAllMenus();
    }

    @Secured({HmsConstants.ROLE_MANAGER, HmsConstants.ROLE_STAFF, HmsConstants.ROLE_GUEST})
    @GetMapping("/{name}")
    public List<MenuDto> getAllMenuByName(@PathVariable String name) {
        return menuService.getAllMenuLikeName(name);
    }


    @Secured({HmsConstants.ROLE_MANAGER, HmsConstants.ROLE_STAFF, HmsConstants.ROLE_GUEST})
    @GetMapping("/search")
    public List<MenuDto> viewHomePage(@RequestParam("keyword") String keyword) {
        return menuService.searchAll(keyword);
    }

    @DeleteMapping("/{id}")
    @Secured({HmsConstants.ROLE_MANAGER})
    public String deleteMenuById(@PathVariable int id) {
        return menuService.deleteByMenuId(id);
    }

    @DeleteMapping("/name/{name}")
    @Secured({HmsConstants.ROLE_MANAGER})
    public Boolean deleteMenuByName(@PathVariable String name) {
        return menuService.deleteByMenuName(name);
    }

//
//
    @PutMapping("/update")
    @Secured({HmsConstants.ROLE_MANAGER})
    public MenuEntity updateMenu(@RequestBody MenuEntity menuEntity) {
        return menuService.updateMenu(menuEntity);
    }

//
//
    //
    //

    @Secured({HmsConstants.ROLE_MANAGER, HmsConstants.ROLE_STAFF, HmsConstants.ROLE_GUEST})
    @GetMapping("/paging")
    public ResponseEntity<List<MenuEntity>> getAllMenusPaging(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy) {
        List<MenuEntity> list = menuService.getAllMenusPaging(pageNo, pageSize, sortBy);

        //return null;
        return new ResponseEntity<List<MenuEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }


}
