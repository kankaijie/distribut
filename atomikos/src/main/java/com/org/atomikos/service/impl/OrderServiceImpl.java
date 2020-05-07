package com.org.atomikos.service.impl;

import com.org.atomikos.entity.ds1.Order;
import com.org.atomikos.entity.ds1.OrderInfo;
import com.org.atomikos.mapper.ds1.OrderInfoMapper;
import com.org.atomikos.mapper.ds1.OrderMapper;
import com.org.atomikos.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void add(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public List<Order> getAllOrderList() {
        return orderMapper.selectAll();
    }
}
