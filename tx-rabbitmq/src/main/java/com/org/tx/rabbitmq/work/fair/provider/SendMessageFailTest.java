package com.org.tx.rabbitmq.work.fair.provider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMessageFailTest {

    @Autowired
    private SendMessageWorkFailController sendMessageWorkController;

    @Test
    public void sendMessageFailTest(){
        System.out.println("======测试工作队列模式，天青色等烟雨======");
        sendMessageWorkController.sendMessage();
    }

}
