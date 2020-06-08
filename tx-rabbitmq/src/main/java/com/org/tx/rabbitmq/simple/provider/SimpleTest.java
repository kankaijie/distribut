package com.org.tx.rabbitmq.simple.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Autowired
    private SendMessageController messageController;

    /***
     *
     */
    @Test
    public void test(){
        System.out.println("=========我是简单队列===========");
        messageController.sendMessage();
    }
}
