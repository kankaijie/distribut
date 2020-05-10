package com.org.tx.order.mapper;


import com.org.tx.order.config.BaseMapper;
import com.org.tx.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderMapper extends BaseMapper<Order,Integer> {
}
