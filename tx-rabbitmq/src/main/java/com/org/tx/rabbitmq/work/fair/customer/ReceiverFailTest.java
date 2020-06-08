package com.org.tx.rabbitmq.work.fair.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiverFailTest {

    @Autowired
    private DireReceiverWorkFailOne direReceiverWorkOne;

    @Autowired
    private DireReceiverWorkFailTwo direReceiverWorkTwo;

    @Test
    public void receiverFailTest() throws IOException {

        direReceiverWorkOne.processOne("====我是workOne====");
        direReceiverWorkTwo.processTwo("====我是workTwo====");

    }
}
