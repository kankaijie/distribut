package com.org.tx.pay.client;

import com.org.tx.order.api.OrderInfoApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;

@Repository
@FeignClient(name = "tx-order")
public interface OrderInfoClient extends OrderInfoApi{
}
