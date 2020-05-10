package com.org.tx.pay;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;


@EnableDistributedTransaction
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(" com.org.tx.pay.mapper")
public class PayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayApplication.class, args);
	}

}
