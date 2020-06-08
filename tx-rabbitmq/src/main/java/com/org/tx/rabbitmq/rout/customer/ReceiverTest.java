package com.org.tx.rabbitmq.rout.customer;

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
    private DirectReciveRoutOne directReciveRoutOne;

    @Autowired
    private DirectReciveRoutTwo directReciveRoutTwo;

    @Test
    public void receiverTest() throws IOException {

        directReciveRoutOne.sendMessage("====我是路由模式One====");
        directReciveRoutTwo.sendMessage("====我是路由模式Two====");

    }
}
