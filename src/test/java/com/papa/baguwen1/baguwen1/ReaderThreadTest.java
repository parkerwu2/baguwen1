package com.papa.baguwen1.baguwen1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReaderThreadTest {
    private static boolean ready = false;
    private static int number = 1;
    public static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (!ready){
//                Thread.yield();
//                System.out.println(Thread.currentThread() + "自循环ready:" + ready);
            }
            System.out.println(Thread.currentThread() + " number:" + number);
            System.out.println(Thread.currentThread() + " ready:" + ready);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 50; i++){
            service.execute(new ReaderThread());
        }
        number = 40;
        ready = true;
        service.shutdownNow();
//        Thread t = new ReaderThread();
//        t.start();
//        number = 40;
//        ready = true;
//        t.join();
        System.out.println("all over");
    }
}
