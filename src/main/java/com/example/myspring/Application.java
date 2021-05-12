package com.example.myspring;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan("com.example.myspring.mapper")
public class Application {

  public static void main(String[] args) {
	SpringApplication app = new SpringApplication(Application.class);
	app.run(args);
  }
}
