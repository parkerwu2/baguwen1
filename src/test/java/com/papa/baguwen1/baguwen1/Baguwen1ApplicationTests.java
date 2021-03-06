package com.papa.baguwen1.baguwen1;

import com.papa.baguwen1.baguwen1.dao.mapper.Ba1Mapper;
import com.papa.baguwen1.baguwen1.dao.pojo.Ba1Example;
import com.papa.baguwen1.baguwen1.drools.PersonService;
import com.papa.baguwen1.baguwen1.drools.drool.Person;
import com.papa.baguwen1.baguwen1.drools.drool.PersonRuleController;
import com.papa.baguwen1.baguwen1.redis.IRedisService;
import com.papa.baguwen1.baguwen1.redis.LuaScriptServiceImpl;
import com.papa.baguwen1.baguwen1.redis.MessageProvider;
import com.papa.baguwen1.baguwen1.redis.bean.Notice;
import com.papa.baguwen1.baguwen1.util.SerializeUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Baguwen1Application.class)
public class Baguwen1ApplicationTests {
    @Autowired
    private IRedisService redisService;
    @Autowired
    private MessageProvider messageProvider;
    @Value("${system.user.password.secret}")
    private String secret;
    @Autowired
    private LuaScriptServiceImpl luaScriptService;
    @Autowired
    private PersonService personService;
    @Autowired
    PersonRuleController controller;
    @Autowired
    private Ba1Mapper ba1Mapper;

    @Test
    public void testDb(){
        long cnt = ba1Mapper.countByExample(new Ba1Example());
        System.out.println("cnt= " + cnt);
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDrools(){
        personService.listPerson().forEach(a -> {
            System.out.println(a.getName() + ", " + a.getAge());
            System.out.println();
        });
    }

    @Test
    public void testLua(){
        luaScriptService.init();
        luaScriptService.redisAddScriptExec();
    }

    @Test
    public void testRedis(){
        Fruit f = new Fruit();
        f.setId(1);
        f.setName("??????");
        f.setType("???");
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
        System.out.println("????????????" + notice);
    }

    @Test
    public void testRedission() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(100);
        Stock stock = new Stock(50);
        for (int i = 0; i < 75; i++){
            StockThread thread = new StockThread("??????" + i, stock);
            es.submit(thread);
        }
        es.shutdownNow();
        es.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
    }

    @Test
    public void sendMessage() {
        messageProvider.sendMessage("??????????????????1", 20);
        messageProvider.sendMessage("??????????????????2", 20);
    }

    @Test
    public void enc(){
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println("pass=" + passwordEncoder.encode("abc"));
        PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder(this.secret);
        //94c6b58b1aa94bfe04a347925c10bd24c2e2e2d9cf0ce7b96b88425e1311ea9d896f76b0edbf5264
        System.out.println("pass=" + passwordEncoder.encode("abc"));
    }

    @Test
    public void testOnePerson() {
        Person bob = new Person();
        bob.setName("bob");

        controller.fireAllRules4One(bob);
    }

    @Test
    public void testTwoPerson() {
        Person bob = new Person();
        bob.setAge(33);

        Person other = new Person();
        other.setAge(88);

        controller.fireAllRules4List(Arrays.asList(bob, other));
    }
}
