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

import static cn.yzw.redis.client.starter.config.RedisClientProperites.REDIS_CLIENT_PREFIX;

/**
 * @author w.dehai.2021/8/12.11:50
 */
@ConditionalOnClass(RedisURI.class)
@EnableConfigurationProperties(RedisClientProperites.class)
@ConditionalOnProperty(prefix = REDIS_CLIENT_PREFIX, value = "server", havingValue = "replica")
public class RedisClientReplicaAutoConfiguration extends RedisClientAutoConfiguration {

    public RedisClientReplicaAutoConfiguration(RedisClientProperites properites) {
        super(properites);
    }

    @Bean
    @Override
    public RedisURI uri() {
        return baseUri();
    }

    @Override
    @Bean(destroyMethod = "shutdown")
    public RedisClient client(ClientResources clientResources, RedisURI uri) {
        return super.client(clientResources, uri);
    }

    @Override
    @Bean(destroyMethod = "close")
    public StatefulRedisConnection<String, String> connection(RedisClient client) {
        return super.connection(client);
    }

    @Bean
    @Override
    public RedisCommands<String, String> commands(StatefulRedisConnection<String, String> connection) {
        return super.commands(connection);
    }

}
