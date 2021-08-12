package cn.yzw.redis.client.starter.client.impl;

import cn.yzw.redis.client.starter.client.RedisClient;
import cn.yzw.redis.client.starter.config.RedisClientProperites;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class Standalone extends AbstractRedisClientImpl implements RedisClient {


//    private JedisPool pool;

    public Standalone(RedisClientProperites properites) {
    }

    @Override
    public void set(String k, String v, int expire, TimeUnit unit) {

    }

    @Override
    public void set(String k, String v, int startExpire, int endExpire, TimeUnit unit) {

    }

    @Override
    public Boolean setNx(String k, String v, int expire, TimeUnit unit) {
        return null;
    }

    @Override
    public Boolean setNx(String k, String v, int startExpire, int endExpire, TimeUnit unit) {
        return null;
    }

    @Override
    public Boolean delete(String k) {
        return null;
    }

    @Override
    public Long delete(Collection<String> keys) {
        return null;
    }

    @Override
    public String get(String k) {
        return null;
    }
}
