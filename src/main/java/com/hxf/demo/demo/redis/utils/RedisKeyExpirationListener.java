package com.hxf.demo.demo.redis.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/9/16 10:30
 */
@Slf4j
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    @Autowired
    private RedisUtil redisUtil;

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 针对redis数据失效事件，进行数据处理
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
        String expiredKey = message.toString();
        Object o = redisUtil.get(expiredKey);
        log.info("expiredKey={}", expiredKey);
        log.info("o={}", o);
        byte[] body = message.getBody();// 建议使用: valueSerializer
        byte[] channel = message.getChannel();
        System.out.print("onMessage >> " );
        System.out.println(String.format("channel: %s, body: %s, pattern: %s"
                ,new String(channel), new String(body), new String(pattern)));
        if(expiredKey.startsWith("Order:")){
            //如果是Order:开头的key，进行处理
        }
    }
}
