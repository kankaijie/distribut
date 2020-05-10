package com.org.tx.order.controller;



import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxTransaction;
import com.org.tx.order.entity.OrderInfo;
import com.org.tx.order.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderInfoService orderInfoService;


    /***
     * 全部查询
     * @return
     */
    @GetMapping("/queryListOrderInfo")
    public List<OrderInfo> queryListOrder(){
        return orderInfoService.getAllOrderInfoList();
    }


    /***
     * 添加
     * @param orderInfo
     */
    @PostMapping("/addOrderInfo")
    public void addOrderInfo(@RequestBody OrderInfo orderInfo){
    orderInfoService.add(orderInfo);
    }
}
