package com.papa.baguwen1.baguwen1.redis;

import com.papa.baguwen1.baguwen1.redis.bean.Notice;

import java.util.Map;

public interface IRedisService {
    // 加入元素
    void setValue(String key, Map<String, Object> value);
    // 加入元素
    void setValue(String key, String value);
    // 加入元素
    void setValue(String key, Object value);
    // 获取元素
    Object getMapValue(String key);
    // 获取元素
    Object getValue(String key);
    //发送消息
    void convertAndSend(String topicName, Notice notice);
}
