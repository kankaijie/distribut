package com.org.tx.order.service.impl;


import com.org.tx.order.entity.Order;
import com.org.tx.order.mapper.OrderMapper;
import com.org.tx.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

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
