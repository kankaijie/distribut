package com.org.tx.pay.controller;

import com.org.tx.order.entity.OrderInfo;
import com.org.tx.pay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {


    @Autowired
    private PayService payService;

    /***
     * 添加
     * @param orderInfo
     */
    @PostMapping("/addPay")
    public void addOrderInfo(@RequestBody OrderInfo orderInfo){
        payService.addOrderInfo(orderInfo);
    }
}
