package com.org.tx.rabbitmq;


import com.org.tx.rabbitmq.simple.customer.DirectReceiver;
import com.org.tx.rabbitmq.simple.provider.SendMessageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TxRabbitmqApplicationTests {


	@Autowired
	private SendMessageController sendMessageController;

	@Autowired
	private DirectReceiver directReceiver;

	@Test
	void contextLoads() {
	//	sendMessageController.sendMessage();
		directReceiver.process("我消费了");
	}

}
