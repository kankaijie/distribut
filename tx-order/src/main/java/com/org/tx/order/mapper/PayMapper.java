package com.org.tx.order.mapper;


import com.org.tx.order.config.BaseMapper;
import com.org.tx.order.entity.Pay;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PayMapper extends BaseMapper<Pay,Integer> {
}
