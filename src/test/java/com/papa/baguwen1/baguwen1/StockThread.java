package com.papa.baguwen1.baguwen1;

import com.papa.baguwen1.baguwen1.redis.DistributedRedisLock;

public class StockThread implements Runnable {
    private String name;
    private Stock stock;

    public StockThread(String name, Stock stock) {
        this.name = name;
        this.stock = stock;
    }

    @Override
    public void run() {
        System.out.println(name + "开始执行");
        String lockName = "库存锁";
        DistributedRedisLock.acquire(lockName);
        System.out.println(name + "获取到锁");
        if (!stock.isOk()){
            System.out.println(name + "库存不足");
        } else {
            stock.minus();
            System.out.println(name + "扣减库存, 剩余库存=" + stock.getStock());
        }
        DistributedRedisLock.release(lockName);
        System.out.println(name + "结束执行");
    }
}
