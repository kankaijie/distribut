package com.org.tx.order.service.impl;
import com.org.tx.order.entity.Pay;
import com.org.tx.order.mapper.PayMapper;
import com.org.tx.order.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayMapper payMapper;

    @Override
    public void add(Pay pay) {
        payMapper.insert(pay);
    }

    @Override
    public List<Pay> getAllPayList() {
        return payMapper.selectAll();
    }
}
