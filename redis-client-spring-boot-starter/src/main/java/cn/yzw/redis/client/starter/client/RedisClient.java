package cn.yzw.redis.client.starter.client;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author w.dehai.2021/8/2.16:01
 */
public class RedisClient {

    @Resource
    private RedisTemplate<String, String> client;

    public void set(String k, String v) {
        client.opsForValue().set(k, v);
    }

    public String get(String k) {
        return client.opsForValue().get(k);
    }

}
