package com.org.tx.product.client;

import com.org.tx.order.api.OrderInfoApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;

@Repository
@FeignClient(name = "tx-order",contextId = "1")
public interface OrderInfoClient extends OrderInfoApi{
}
