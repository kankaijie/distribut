package com.org.atomikos.service.impl;
import com.org.atomikos.entity.ds1.Pay;
import com.org.atomikos.mapper.ds1.PayMapper;
import com.org.atomikos.service.PayService;
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
