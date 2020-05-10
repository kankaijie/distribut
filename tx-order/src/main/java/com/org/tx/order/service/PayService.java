package com.org.tx.order.service;



import com.org.tx.order.entity.Pay;

import java.util.List;

public interface PayService {

    public void add(Pay pay);

    public List<Pay> getAllPayList();
}
