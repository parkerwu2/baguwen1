package com.papa.baguwen1.baguwen1;

import com.papa.baguwen1.baguwen1.redis.IRedisService;
import com.papa.baguwen1.baguwen1.util.SerializeUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Baguwen1ApplicationTests {
    @Autowired
    private IRedisService redisService;
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
}
