package com.hxf.demo.demo.redis.api;

import com.hxf.demo.demo.redis.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hcx
 * @version 1.0
 * @date 2020/9/16 10:00
 */
@RequestMapping("/redis")
@RestController
public class RedisController {
    /**
     * redis中存储的过期时间60s
     */
    private static int EXPIRE_TIME = 10;

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/set/{key}/{value}")
    public boolean set(@PathVariable("key") String key, @PathVariable("value") String value) {
        return redisUtil.set(key, value);
    }

    @GetMapping("/get/{key}")
    public Object get(@PathVariable("key") String key) {
        return redisUtil.get(key);
    }


    @GetMapping("/keys/{pattern}")
    public Object keys(@PathVariable("pattern") String pattern) {
        return redisUtil.keys(pattern);
    }

    @GetMapping("/expire/{key}")
    public boolean expire(@PathVariable("key") String key) {
        return redisUtil.expire(key, EXPIRE_TIME);
    }
}
