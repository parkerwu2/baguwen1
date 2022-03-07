package com.papa.baguwen1.baguwen1.configuration;

import org.redisson.Redisson;
import org.redisson.config.Config;

public class RedissonManager {
    private static Config config = new Config();
    //声明redisso对象
    private static Redisson redisson = null;
    //实例化redisson
    static{
        System.out.println("创建redission");
        //单个redis节点
        config.useSingleServer().setAddress("127.0.0.1:6379");
//        //集群
//        config.useClusterServers();
//        //哨兵
//        config.useSentinelServers();
//        //主从
//        config.useMasterSlaveServers();
        //得到redisson对象
        try {
            redisson = (Redisson) Redisson.create(config);
        } catch (Exception e){
            System.out.println("redisson创建失败");
        }
    }

    //获取redisson对象的方法
    public static Redisson getRedisson(){
        System.out.println("获取redission");
        return redisson;
    }
}
