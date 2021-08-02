package cn.yzw.redis.client.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static cn.yzw.redis.client.starter.config.RedisClientProperites.REDIS_CLIENT_PREFIX;

/**
 * @author w.dehai.2021/8/2.16:02
 */
@Data
@ConfigurationProperties(prefix = REDIS_CLIENT_PREFIX)
public class RedisClientProperites {

    static final String REDIS_CLIENT_PREFIX = "redis.client";

    private String host;
    private Integer port = 6379;
    private RedisClientSerializer serializableStrategy;

}
