//package com.meetup.hotel_management_system.controller;
//
//import com.meetup.hotel_management_system.constant.HmsConstants;
//import com.meetup.hotel_management_system.dto.OrderInfoDto;
//import com.meetup.hotel_management_system.service.OrderInfoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/orderInfo")
//public class OrderInfoController {
//
//    @Autowired
//    private OrderInfoService orderInfoService;
//
//    @Secured({HmsConstants.ROLE_MANAGER, HmsConstants.ROLE_STAFF})
//    @PostMapping
//    public String createOrderInfo(@RequestBody OrderInfoDto orderInfoDto){
//
//         orderInfoService.saveOrderInfo(orderInfoDto);
//        return String.format("order info added by staff %s" ,orderInfoDto.getStaff().getUsername()) ;
//    }
//
//
//}
