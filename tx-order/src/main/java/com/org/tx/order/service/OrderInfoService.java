package com.org.tx.order.service;


import com.org.tx.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderInfoService {

    public void add(OrderInfo orderInfo);

    public List<OrderInfo> getAllOrderInfoList();
}
