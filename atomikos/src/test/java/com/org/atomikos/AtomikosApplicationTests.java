package com.org.atomikos;

import com.org.atomikos.service.TestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AtomikosApplicationTests {

	@Autowired
	private TestService testService;

	@Test
	void contextLoads() {
		testService.insertTest();
	}

}
