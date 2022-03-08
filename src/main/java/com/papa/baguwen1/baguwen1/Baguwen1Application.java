package com.papa.baguwen1.baguwen1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//打开定时
@EnableScheduling
@SpringBootApplication
public class Baguwen1Application {

    public static void main(String[] args) {
        SpringApplication.run(Baguwen1Application.class, args);
    }

}
