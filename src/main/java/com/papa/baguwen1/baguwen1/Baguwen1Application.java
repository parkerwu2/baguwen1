package com.papa.baguwen1.baguwen1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;

//打开定时
@EnableScheduling
@SpringBootApplication
@MapperScan("com.papa.baguwen1.baguwen1.dao.mapper")
@ConditionalOnProperty(prefix="study", name ="enabled", havingValue = "true")
public class Baguwen1Application {

    public static void main(String[] args) {
        SpringApplication.run(Baguwen1Application.class, args);
    }

}
