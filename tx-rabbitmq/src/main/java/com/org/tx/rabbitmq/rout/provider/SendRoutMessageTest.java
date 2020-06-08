package com.org.tx.rabbitmq.rout.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SendRoutMessageTest {

   @Autowired
   private SendMessageRoutController sendMessage;

    @Test
    public void receiverRoutTest() throws IOException {

        sendMessage.sendMessage();


    }
}
