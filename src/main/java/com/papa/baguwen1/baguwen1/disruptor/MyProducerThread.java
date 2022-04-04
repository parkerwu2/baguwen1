package com.papa.baguwen1.baguwen1.disruptor;

import java.util.Calendar;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class MyProducerThread implements Runnable {
    private String name;
    private DisruptorQueue disruptorQueue;
    private volatile boolean flag = true;
    private static AtomicInteger count = new AtomicInteger();
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    public MyProducerThread(String name, DisruptorQueue disruptorQueue) {
        this.name = name;
        this.disruptorQueue = disruptorQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println(now() + this.name + "：线程启动。");
            cyclicBarrier.await();
            while (flag) {
                String data = count.incrementAndGet()+"";
                // 将数据存入队列中
                disruptorQueue.add(data);
                System.out.println(now() + this.name + "：存入" + data + "到队列中。");
            }
        } catch (Exception e) {

        } finally {
            System.out.println(now() + this.name + "：退出线程。");
        }
    }

    public void stopThread() {
        this.flag = false;
    }

    // 获取当前时间（分:秒）
    public String now() {
        Calendar now = Calendar.getInstance();
        return "[" + now.get(Calendar.MINUTE) + ":" + now.get(Calendar.SECOND) + "] ";
    }
}
