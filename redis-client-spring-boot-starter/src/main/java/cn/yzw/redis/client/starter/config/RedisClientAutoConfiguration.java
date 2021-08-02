package cn.yzw.redis.client.starter.config;

import cn.yzw.redis.client.starter.client.RedisClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author w.dehai.2021/8/2.16:03
 */
@EnableConfigurationProperties(RedisClientProperites.class)
public class RedisClientAutoConfiguration {

    @Bean
    public RedisClient redisClient() {
        RedisClient client = new RedisClient();
        return client;
    }

}
