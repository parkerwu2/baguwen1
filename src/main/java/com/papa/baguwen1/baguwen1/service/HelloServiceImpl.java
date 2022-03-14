package com.papa.baguwen1.baguwen1.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class HelloServiceImpl {
    @Value("${study.testStr}")
    private String testStr;

    public String sayHello(){
        return "Hello!!" + testStr;
    }
}
