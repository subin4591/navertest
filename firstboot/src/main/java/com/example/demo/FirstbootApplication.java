package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import upload.MyPathConfig;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.demo")
@ComponentScan(basePackageClasses = MyPathConfig.class)
@ComponentScan(basePackages = "errors")
@ComponentScan(basePackages = "board.spring.mybatis")
@MapperScan(basePackages = "board.spring.mybatis")
public class FirstbootApplication {
	// 스프링 부트 메인 클래스
	// 자동 서버 시작 - @패키지 스캔 자동 포함
	// jsp 파일 경로, 확장자 비포함 - 수동 추가 설정
	// xml 최소화 - application.properties 파일 설정
	public static void main(String[] args) {
		SpringApplication.run(FirstbootApplication.class, args);
		System.out.println("서버 시작 중");
	}
}