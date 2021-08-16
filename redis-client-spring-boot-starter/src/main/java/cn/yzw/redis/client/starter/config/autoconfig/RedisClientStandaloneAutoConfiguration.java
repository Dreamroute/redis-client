package cn.yzw.redis.client.starter.config.autoconfig;

import cn.yzw.redis.client.starter.config.RedisClientProperites;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.resource.ClientResources;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author w.dehai.2021/8/12.11:50
 */
@ConditionalOnClass(RedisURI.class)
@EnableConfigurationProperties(RedisClientProperites.class)
@ConditionalOnProperty(prefix = RedisClientProperites.REDIS_CLIENT_PREFIX, value = "server", havingValue = "standalone")
public class RedisClientStandaloneAutoConfiguration extends RedisClientBaseConfig {

    public RedisClientStandaloneAutoConfiguration(RedisClientProperites properites) {
        super(properites);
    }

    @Bean
    @Override
    public RedisURI uri() {
        return super.baseUri();
    }

    @Bean(destroyMethod = "shutdown")
    public RedisClient client(ClientResources clientResources, RedisURI uri) {
        return RedisClient.create(clientResources, uri);
    }

    @Bean(destroyMethod = "close")
    public StatefulRedisConnection<String, String> connection(RedisClient client) {
        return client.connect();
    }

    @Bean
    public RedisCommands<String, String> commands(StatefulRedisConnection<String, String> connection) {
        return connection.sync();
    }

}
