package cn.yzw.redis.client.starter.client.impl;

import cn.yzw.redis.client.starter.client.RedisClient;
import cn.yzw.redis.client.starter.config.RedisClientProperites;
import cn.yzw.redis.client.starter.config.RedisClientProperites.Pool;
import lombok.NoArgsConstructor;
import redis.clients.jedis.JedisPoolConfig;

@NoArgsConstructor
public abstract class AbstractRedisClientImpl implements RedisClient {

    protected JedisPoolConfig config = new JedisPoolConfig();

    protected AbstractRedisClientImpl(RedisClientProperites properites) {
        Pool pool = properites.getPool();
        config.setMaxTotal(pool.getMaxTotal());
        config.setMaxIdle(pool.getMaxIdle());
        config.setMinIdle(pool.getMinIdle());
    }

}
