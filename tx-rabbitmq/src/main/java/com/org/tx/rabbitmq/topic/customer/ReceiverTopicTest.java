package com.org.tx.rabbitmq.topic.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReceiverTopicTest {

    @Autowired
    private DirectTopicOne directTopicOne;

    @Autowired
    private  DirectTopicTwo directTopicTwo;

    @Test
    public void receiverTopicTest() throws IOException {

        directTopicOne.sendMessage("====我是Topic模式One====");
        directTopicTwo.sendMessage("====我是Topic模式Two====");

    }
}
