package com.org.atomikos.service.impl;
import com.org.atomikos.entity.ds1.OrderInfo;
import com.org.atomikos.mapper.ds1.OrderInfoMapper;
import com.org.atomikos.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService{

    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Transactional
    @Override
    public void add(OrderInfo orderInfo) {
        orderInfoMapper.insert(orderInfo);
    }

    @Override
    public List<OrderInfo> getAllOrderInfoList() {
        return orderInfoMapper.selectAll();
    }
}
