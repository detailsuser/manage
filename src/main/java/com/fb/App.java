package com.fb;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableScheduling
@EnableJms
@MapperScan("com.fb.manage.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }
}
