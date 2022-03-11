package com.papa.baguwen1.baguwen1.importor;

public class TestA {
    public void printName() {
        System.out.println("类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }
}
