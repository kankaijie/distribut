package com.org.atomikos.service;

import com.org.atomikos.entity.ds1.Order;
import com.org.atomikos.entity.ds1.Pay;

import java.util.List;

public interface PayService {

    public void add(Pay pay);

    public List<Pay> getAllPayList();
}
