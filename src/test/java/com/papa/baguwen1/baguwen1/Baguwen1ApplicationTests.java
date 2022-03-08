package com.papa.baguwen1.baguwen1;

import com.papa.baguwen1.baguwen1.redis.IRedisService;
import com.papa.baguwen1.baguwen1.redis.MessageProvider;
import com.papa.baguwen1.baguwen1.redis.bean.Notice;
import com.papa.baguwen1.baguwen1.util.SerializeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class Baguwen1ApplicationTests {
    @Autowired
    private IRedisService redisService;
    @Autowired
    private MessageProvider messageProvider;

    @Test
    void contextLoads() {
    }

    @Test
    public void testRedis(){
        Fruit f = new Fruit();
        f.setId(1);
        f.setName("生梨");
        f.setType("甜");
        SerializeUtil.serialize(f);
        redisService.setValue("a", "abc");
        redisService.setValue("fruit2", f);
        String v1 = (String)redisService.getValue("a");
        System.out.println("v1=" + v1);
        Fruit f2 = (Fruit)redisService.getValue("fruit2");
        System.out.println("f=" + f2.getName() + "," + f2.getType() + ", " + f2.getId());
    }

    @Test
    public void sendNotice(){
        Notice notice = new Notice("papa", "fight");
        redisService.convertAndSend("topicName", notice);
        System.out.println("发送消息" + notice);
    }

    @Test
    public void testRedission() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(100);
        Stock stock = new Stock(50);
        for (int i = 0; i < 75; i++){
            StockThread thread = new StockThread("线程" + i, stock);
            es.submit(thread);
        }
        es.shutdownNow();
        es.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    @Test
    void sendMessage() {
        messageProvider.sendMessage("同时发送消息1", 20);
        messageProvider.sendMessage("同时发送消息2", 20);
    }
}
