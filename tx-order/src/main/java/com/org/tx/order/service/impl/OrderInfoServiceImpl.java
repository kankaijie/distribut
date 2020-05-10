package com.org.tx.order.service.impl;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.org.tx.order.entity.OrderInfo;
import com.org.tx.order.mapper.OrderInfoMapper;
import com.org.tx.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderInfoMapper orderInfoMapper;


    @LcnTransaction
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void add(OrderInfo orderInfo) {
        orderInfoMapper.insert(orderInfo);
    }

    @Override
    public List<OrderInfo> getAllOrderInfoList() {
        return orderInfoMapper.selectAll();
    }
}
