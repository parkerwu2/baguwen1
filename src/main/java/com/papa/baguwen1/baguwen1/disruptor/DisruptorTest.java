package com.papa.baguwen1.baguwen1.disruptor;

public class DisruptorTest {
    public static void main(String[] args) throws InterruptedException {

        // 创建一个消费者
        MyConsumer myConsumer = new MyConsumer("---->消费者1");

        // 创建一个Disruptor队列操作类对象（RingBuffer大小为4，false表示只有一个生产者）
        DisruptorQueue disruptorQueue = DisruptorQueueFactory.getHandleEventsQueue(4,
                false, myConsumer);

        // 创建一个生产者，开始模拟生产数据
        MyProducerThread myProducerThread = new MyProducerThread("11111生产者1", disruptorQueue);
        Thread t1 = new Thread(myProducerThread);
        t1.start();

        // 执行3s后，生产者不再生产
        Thread.sleep(3 * 1000);
        myProducerThread.stopThread();
    }
}
