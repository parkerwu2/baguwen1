package com.papa.baguwen1.baguwen1.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service("luaScriptService")
public class LuaScriptServiceImpl{
    @Autowired
    private RedisTemplate<String,Object> redisTemplate1;

    private DefaultRedisScript<List> getRedisScript;

    @PostConstruct
    public void init(){
        getRedisScript = new DefaultRedisScript<List>();
        getRedisScript.setResultType(List.class);
        getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("luascript/lua1.lua")));
    }

    public void lua1(){
        String key = "testredislua";
        redisTemplate1.delete(key);
        redisTemplate1.opsForValue().set(key, "hahaha");
        String s = redisTemplate1.opsForValue().get(key).toString();
        System.out.println(s);

        List luaresp = (List)redisTemplate1.execute(getRedisScript, Collections.singletonList(key), "hahaha", "3333");
        System.out.println("luareps=" + luaresp.get(0));
        s = redisTemplate1.opsForValue().get(key).toString();
        System.out.println(s);
    }

    public void redisAddScriptExec(){
        /**
         * List设置lua的KEYS
         */
        List<String> keyList = new ArrayList();
        keyList.add("count");
        keyList.add("rate.limiting:127.0.0.1");

        /**
         * 用Mpa设置Lua的ARGV[1]
         */
        Map<String,Object> argvMap = new HashMap<String,Object>();
        argvMap.put("expire",10000);
        argvMap.put("times",10);

        /**
         * 调用脚本并执行
         */
        List result = redisTemplate1.execute(getRedisScript,keyList, argvMap);
        System.out.println(result);

    }
}
