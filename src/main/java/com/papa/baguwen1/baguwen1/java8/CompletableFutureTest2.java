package com.papa.baguwen1.baguwen1.java8;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest2 {
    public static void main(String[] args) {
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(()->{
            System.out.println("任务1开始做");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务1结束");
        });
        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(()->{
            System.out.println("任务2开始做");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("任务2结束");
            return "world";
        });
        CompletableFuture<String> f3 = f1.thenCombine(f2, (f1result,f2result) -> {
            System.out.println("f1返回"+ f1result);
            System.out.println("f2返回"+ f2result);
            return "hello" + f2result;
        });
        System.out.println(f3.join());
    }
}
