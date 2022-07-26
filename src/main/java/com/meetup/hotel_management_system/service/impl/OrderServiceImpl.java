package com.meetup.hotel_management_system.service.impl;

import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.exception.BusinessException;
import com.meetup.hotel_management_system.repository.MenuRepository;
import com.meetup.hotel_management_system.repository.OrderInfoRepository;
import com.meetup.hotel_management_system.repository.OrderRepository;
import com.meetup.hotel_management_system.repository.entity.MenuEntity;
import com.meetup.hotel_management_system.repository.entity.OrderEntity;
import com.meetup.hotel_management_system.service.OrderService;
import com.meetup.hotel_management_system.util.helper.OrderHelper;
import com.meetup.hotel_management_system.util.helper.OrderInfoHelper;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Override
    public OrderDto saveOrder(OrderDto orderDto) throws BusinessException {

       var notAvailable= orderDto.getMenuDetails().stream()
                .map(menuDetail -> menuRepository.findById(menuDetail.getMenuId()))
                .map(menu -> menu.orElse(null)).filter(Objects::nonNull)
                .anyMatch(menu->!menu.isAvailable())
               ;

       if(notAvailable){

           throw new BusinessException("Menu not available");
       }
        var orderInfoEntity = OrderInfoHelper.mapToEntityFromOrder(orderDto);
        orderInfoEntity.setStatus("ORDERED");
        var comittedOrderInfoEntity = orderInfoRepository.saveAndFlush(orderInfoEntity);


        var orderDetailsEntity = orderDto.getMenuDetails().stream()
                .map(menuDetails -> OrderHelper.mapToOrderEntityFromMenuDetails
                        (menuDetails, comittedOrderInfoEntity,"ORDER COMPLETED"))
                .collect(Collectors.toList());


        orderRepository.saveAll(orderDetailsEntity);
        return null;
    }






//    @Override
//    public OrderEntity updateOrder(OrderEntity orderEntity) throws BusinessException {
//
//        Optional<OrderEntity> existing = orderRepository.findById(orderEntity.getId());
//
//        if (existing.isPresent()) {
//            throw new BusinessException("order not exist");
//        }
//
//            OrderEntity existingOrder = orderRepository.findById(orderEntity.getId()).orElse(null);
//        existingOrder.setMenu(orderEntity.getMenu());
//        existingOrder.setOrderInfo(orderEntity.getOrderInfo());
//        existingOrder.setQuantity(orderEntity.getQuantity());
//        existingOrder.setDescription(orderEntity.getDescription());
//        existingOrder.setStatus(orderEntity.getStatus());
//        existingOrder.setId(orderEntity.getId());
//            return orderRepository.save(existingOrder);
//        }





}
