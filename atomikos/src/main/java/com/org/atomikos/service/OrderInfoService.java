package com.org.atomikos.service;

import com.org.atomikos.entity.ds1.Order;
import com.org.atomikos.entity.ds1.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderInfoService {

    public void add(OrderInfo orderInfo);

    public List<OrderInfo> getAllOrderInfoList();
}
