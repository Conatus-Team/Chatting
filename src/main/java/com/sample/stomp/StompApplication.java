package com.sample.stomp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StompApplication {

    public static void main(String[] args) {
    	System.out.println("#################### server start #####################");
        SpringApplication.run(StompApplication.class, args);
        
    }

}
