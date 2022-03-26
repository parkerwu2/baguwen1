package com.papa.baguwen1.baguwen1;

import java.util.concurrent.*;

public class ThreadDeathLock {
    ExecutorService es = Executors.newSingleThreadExecutor();

    public String run() throws ExecutionException, InterruptedException {
        Future<String> f = es.submit(new Callable<String>() {

            @Override
            public String call() throws Exception {
                System.out.println("执行f开始");
                Future<Integer> f2 = es.submit(new Callable<Integer>() {
                    @Override
                    public Integer call() throws Exception {
                        System.out.println("执行f2开始");
                        return 1;
                    }
                });
                return f2.get().toString();
            }
        });
        return f.get();
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDeathLock tdl = new ThreadDeathLock();
        tdl.run();
        System.out.println("all over");
    }
}
