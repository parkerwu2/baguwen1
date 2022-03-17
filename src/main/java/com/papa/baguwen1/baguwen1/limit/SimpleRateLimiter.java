package com.papa.baguwen1.baguwen1.limit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Service
public class SimpleRateLimiter {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) {
        String key = String.format("hist:%s:%s", userId, actionKey);
        long current = System.currentTimeMillis();
        // 记录行为
        redisTemplate.opsForZSet().add(key, current, current);
        // 移除时间窗口之前的行为记录，剩下的都是时间窗口内的
        redisTemplate.opsForZSet().removeRangeByScore(key, 0, current - period * 1000);
        // 获取窗口内的行为数量
        Long zCard = redisTemplate.opsForZSet().zCard(key);
        // 设置zset过期时间，避免冷用户持续占用内存
        // 过期时间应该等于时间窗口长度，再多宽限1s
        redisTemplate.expire(key, period + 1, TimeUnit.SECONDS);
        return zCard <= maxCount;
    }
}
