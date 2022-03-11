package com.papa.baguwen1.baguwen1.importor;

import org.springframework.context.annotation.Configuration;

@Configuration
public class TestB {
    public void printName() {
        System.out.println("类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }
}
