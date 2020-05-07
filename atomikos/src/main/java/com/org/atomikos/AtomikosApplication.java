package com.org.atomikos;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan( "com.org.atomikos.mapper")
public class AtomikosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtomikosApplication.class, args);
	}

}
