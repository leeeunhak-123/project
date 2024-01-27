package com.example.birth_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.birth_service.mapper") //매퍼의 패키지 경로 지정
public class BirthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirthServiceApplication.class, args);
	}

}
