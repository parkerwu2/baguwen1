package com.papa.baguwen1.baguwen1.java8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
    private void work(){
        CompletableFuture.supplyAsync(()->{
            System.out.println("do supply");
            return 1;
        }).thenApplyAsync(num -> {
            System.out.println(++num);
            return num;
        }).whenCompleteAsync((resp, error)->{
            System.out.println("resp=" + resp);
            System.out.println("error=" + error);
        });
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("start");
        new CompletableFutureTest().work();
            Thread.sleep(2000);
        System.out.println("over");
    }
}
