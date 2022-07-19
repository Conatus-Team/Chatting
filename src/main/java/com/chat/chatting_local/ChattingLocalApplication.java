package com.chat.chatting_local;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ChattingLocalApplication {
    public static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = SpringApplication.run(ChattingLocalApplication.class, args);
    }

//    public static void main(String[] args) {
//        SpringApplication.run(ChattingLocalApplication.class, args);
//    }

}
