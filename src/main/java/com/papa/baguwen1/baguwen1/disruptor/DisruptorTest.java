package com.papa.baguwen1.baguwen1.disruptor;

public class DisruptorTest {
    public static void main(String[] args) throws InterruptedException {
        // 创建一个消费者
        MyConsumer myConsumer = new MyConsumer("---->消费者1");
        MyConsumer myConsumer2 = new MyConsumer("---->消费者2");
        MyConsumer myConsumer3 = new MyConsumer("---->消费者3");

        // 创建一个Disruptor队列操作类对象（RingBuffer大小为4，false表示只有一个生产者）
        DisruptorQueue disruptorQueue = DisruptorQueueFactory.getHandleEventsQueue(16,
                false, myConsumer, myConsumer2, myConsumer3);

        // 创建一个生产者，开始模拟生产数据
        MyProducerThread myProducerThread = new MyProducerThread("11111生产者1", disruptorQueue);
        Thread t1 = new Thread(myProducerThread);
        t1.start();
        MyProducerThread myProducerThread2 = new MyProducerThread("22222生产者2", disruptorQueue);
        Thread t2 = new Thread(myProducerThread2);
        t2.start();
        MyProducerThread myProducerThread3 = new MyProducerThread("33333生产者3", disruptorQueue);
        Thread t3 = new Thread(myProducerThread3);
        t3.start();

        // 执行3s后，生产者不再生产
        Thread.sleep(5 * 1000);
        myProducerThread.stopThread();
        myProducerThread2.stopThread();
        myProducerThread3.stopThread();
        disruptorQueue.shutdown();
    }
}
