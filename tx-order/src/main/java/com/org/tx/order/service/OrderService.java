package com.org.tx.order.service;



import com.org.tx.order.entity.Order;

import java.util.List;

public interface OrderService {

    public void add(Order order);

    public List<Order> getAllOrderList();
}
