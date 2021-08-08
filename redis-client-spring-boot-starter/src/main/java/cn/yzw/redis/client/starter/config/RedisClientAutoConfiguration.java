package cn.yzw.redis.client.starter.config;

import cn.yzw.redis.client.starter.client.RedisClient;
import cn.yzw.redis.client.starter.client.RedisClientImpl;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @author w.dehai.2021/8/2.16:03
 */
@AutoConfigureAfter(RedisAutoConfiguration.class)
@EnableConfigurationProperties(RedisClientProperites.class)
public class RedisClientAutoConfiguration {

    @Resource
    private RedisTemplate<String, String> client;

    @Bean
    public RedisClient redisClient(RedisClientProperites properites) {
        return new RedisClientImpl(client);
    }

//    @Bean
//    public RedisTemplate<String, Serializable> redisTemplate(LettuceConnectionFactory connectionFactory) {
//        RedisTemplate<String, Serializable> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//        redisTemplate.setConnectionFactory(connectionFactory);
//        return redisTemplate;
//    }

//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//
//        return template;
//    }

}
