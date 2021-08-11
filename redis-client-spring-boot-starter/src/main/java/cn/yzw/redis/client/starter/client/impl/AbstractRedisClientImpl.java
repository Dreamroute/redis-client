package cn.yzw.redis.client.starter.client.impl;

import cn.yzw.redis.client.starter.client.RedisClient;
import cn.yzw.redis.client.starter.config.RedisClientProperites;
import lombok.NoArgsConstructor;
import redis.clients.jedis.JedisPoolConfig;

@NoArgsConstructor
public abstract class AbstractRedisClientImpl implements RedisClient {

    protected JedisPoolConfig config = new JedisPoolConfig();

    protected AbstractRedisClientImpl(RedisClientProperites properites) {
    }

}
