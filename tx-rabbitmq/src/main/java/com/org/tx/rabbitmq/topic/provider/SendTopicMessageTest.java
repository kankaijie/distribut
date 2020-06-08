package com.org.tx.rabbitmq.topic.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SendTopicMessageTest {

   @Autowired
   private SendMessageTopicController sendMessage;

    @Test
    public void receiverTopicTest() throws IOException {

        sendMessage.sendMessage();


    }
}
