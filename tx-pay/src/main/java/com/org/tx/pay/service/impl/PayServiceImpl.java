package com.org.tx.pay.service.impl;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.org.tx.order.entity.OrderInfo;
import com.org.tx.order.mapper.PayMapper;
import com.org.tx.pay.client.OrderInfoClient;
import com.org.tx.pay.entity.LogsInfo;
import com.org.tx.pay.mapper.LogsInfoMapper;
import com.org.tx.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    OrderInfoClient orderInfoClient;

    @Autowired
    private LogsInfoMapper logsInfoMapper;

    @LcnTransaction
    @Override
    public void addOrderInfo(OrderInfo orderInfo) {
        orderInfoClient.addOrderInfo(orderInfo);
        LogsInfo logsInfo=new LogsInfo();
        logsInfo.setContent("天青色等烟雨");
        logsInfo.setCreateTime(new Date());
        int i=10/0;
        logsInfoMapper.insert(logsInfo);
    }
}
