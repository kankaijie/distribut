package com.org.atomikos.service.impl;
import com.org.atomikos.entity.ds1.Order;
import com.org.atomikos.entity.ds1.OrderInfo;
import com.org.atomikos.entity.ds2.LogsInfo;
import com.org.atomikos.mapper.ds1.OrderInfoMapper;
import com.org.atomikos.mapper.ds1.OrderMapper;
import com.org.atomikos.mapper.ds2.LogsInfoMapper;
import com.org.atomikos.service.TestService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Log
@Service
public class TestServiceImpl implements TestService{

    @Autowired
    private LogsInfoMapper logsInfoMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderInfoMapper orderInfoMapper;


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertTest() {
        try {
            LogsInfo logsInfo = new LogsInfo();
            logsInfo.setContent("我是插入的数据");
            logsInfo.setCreateTime(new Date());
            Integer count = logsInfoMapper.insert(logsInfo);
            if (count != 1) {
                log.info("==========插入异常logsInfo=========");
                return;
            }




            OrderInfo orderInfo=new OrderInfo();
            orderInfo.setMoney(new BigDecimal(7.89));
            orderInfo.setAddress("情雪湖");
            orderInfo.setCreateTime(new Date());
            orderInfo.setUserId(1);
            Integer countOrderInfo=orderInfoMapper.insert(orderInfo);
            if (countOrderInfo != 1) {
                log.info("==========Order=========");
                return;
            }


           int i=1/0;



        }catch (Exception e){
            log.info("==========插入异常========="+e);
            throw new RuntimeException("注册用户:数据库保存异常");
        }
    }
}
