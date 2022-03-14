package com.papa.baguwen1.baguwen1;

import com.papa.baguwen1.baguwen1.redis.IRedisService;
import com.papa.baguwen1.baguwen1.redis.MessageProvider;
import com.papa.baguwen1.baguwen1.redis.bean.Notice;
import com.papa.baguwen1.baguwen1.util.SerializeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = Baguwen1Application.class)
class Baguwen1ApplicationTests {
    @Autowired
    private IRedisService redisService;
    @Autowired
    private MessageProvider messageProvider;
    @Value("${system.user.password.secret}")
    private String secret;

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

    @Test
    public void enc(){
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println("pass=" + passwordEncoder.encode("abc"));
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(this.secret);
        //94c6b58b1aa94bfe04a347925c10bd24c2e2e2d9cf0ce7b96b88425e1311ea9d896f76b0edbf5264
        System.out.println("pass=" + passwordEncoder.encode("abc"));
    }
}
