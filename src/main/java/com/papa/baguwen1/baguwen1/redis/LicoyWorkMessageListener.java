package com.papa.baguwen1.baguwen1.redis;

import com.papa.baguwen1.baguwen1.redis.bean.Notice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LicoyWorkMessageListener extends MessageListenerAdapter {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void onMessage(Message message, byte[] pattern) {
        byte[] body = message.getBody();

        byte[] channel = message.getChannel();

        String topic = (String) redisTemplate.getStringSerializer().deserialize(channel);

        if(!topic.equals("topicName")){
            return;

        }

        Object res = redisTemplate.getValueSerializer().deserialize(body);

        if(res instanceof Notice){ //如果反序列化得到的是我们定义的消息数据体类型

            Notice notice = (Notice)res;

            System.out.println("监听到消息:" + notice);

        }else{
            //其他处理

        }

    }

}