package cn.yzw.redis.client.starter.config;

import cn.yzw.redis.client.starter.msic.JsonSerializationRedisSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

/**
 * @author w.dehai.2021/8/2.17:13
 */
@Getter
@AllArgsConstructor
public enum RedisClientSerializer {
    STRING(String.class),
    JDK(JdkSerializationRedisSerializer.class),
    JSON(JsonSerializationRedisSerializer.class);

    private Class<?> seria;
}
