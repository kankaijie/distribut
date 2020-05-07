package com.org.atomikos.service;

import com.org.atomikos.entity.ds1.Order;

import java.util.List;

public interface OrderService {

    public void add(Order order);

    public List<Order> getAllOrderList();
}
