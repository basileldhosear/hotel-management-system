package com.meetup.hotel_management_system.service.impl;

import com.meetup.hotel_management_system.dto.OrderDto;
import com.meetup.hotel_management_system.dto.OrderInfoDto;
import com.meetup.hotel_management_system.repository.OrderInfoRepository;
import com.meetup.hotel_management_system.repository.OrderRepository;
import com.meetup.hotel_management_system.service.OrderInfoService;
import com.meetup.hotel_management_system.util.helper.OrderHelper;
import com.meetup.hotel_management_system.util.helper.OrderInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoRepository orderInfoRepository;

    @Override
    public OrderInfoDto saveOrderInfo(OrderInfoDto orderInfoDto) {
        return OrderInfoHelper.mapToDto(orderInfoRepository.saveAndFlush(OrderInfoHelper.mapToEntity(orderInfoDto)));
    }


}
