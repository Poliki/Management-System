package com.example.meetingdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.meetingdemo.mapper")
@SpringBootApplication
public class MeetingdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeetingdemoApplication.class, args);
    }

}
