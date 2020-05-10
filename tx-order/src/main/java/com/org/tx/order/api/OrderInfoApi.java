package com.org.tx.order.api;

import com.org.tx.order.entity.OrderInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface OrderInfoApi {

    /***
     * 添加
     * @param orderInfo
     */
    @PostMapping("/addOrderInfo")
    public void addOrderInfo(@RequestBody OrderInfo orderInfo);
}
