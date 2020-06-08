package com.org.tx.rabbitmq.subscribe.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiverTest {

    @Autowired
    private DirectReciveSubscribeOne direReceiverWorkOne;

    @Autowired
    private DirectReciveSubscribeTwo direReceiverWorkTwo;

    @Test
    public void receiverTest() throws IOException {

        direReceiverWorkOne.sendMessage("====我是订阅模式One====");
        direReceiverWorkTwo.sendMessage("====我是订阅模式Two====");

    }
}
