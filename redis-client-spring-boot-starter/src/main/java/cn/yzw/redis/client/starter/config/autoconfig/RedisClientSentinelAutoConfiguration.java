package cn.yzw.redis.client.starter.config.autoconfig;

import cn.yzw.redis.client.starter.config.RedisClientProperites;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.sentinel.api.StatefulRedisSentinelConnection;
import io.lettuce.core.sentinel.api.sync.RedisSentinelCommands;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

/**
 * @author w.dehai.2021/8/12.11:50
 */
@ConditionalOnClass(RedisURI.class)
@EnableConfigurationProperties(RedisClientProperites.class)
@ConditionalOnProperty(prefix = RedisClientProperites.REDIS_CLIENT_PREFIX, value = "server", havingValue = "sentinel")
public class RedisClientSentinelAutoConfiguration extends RedisClientBaseConfig {

    public RedisClientSentinelAutoConfiguration(RedisClientProperites properites) {
        super(properites);
    }

    @Bean
    @Override
    public RedisURI uri() {
        RedisURI uri = super.baseUri();
        String masterId = properites.getSentinel().getMasterId();
        if (StringUtils.isEmpty(masterId)) {
            throw new IllegalArgumentException("哨兵模式下需要设置masterId");
        }
        uri.setSentinelMasterId(masterId);
        return uri;
    }

    @Bean(destroyMethod = "shutdown")
    public RedisClient client(ClientResources clientResources, RedisURI uri) {
        return RedisClient.create(clientResources, uri);
    }

    @Bean(destroyMethod = "close")
    public StatefulRedisSentinelConnection<String, String> connection(RedisClient client) {
        return client.connectSentinel();
    }

    @Bean
    public RedisSentinelCommands<String, String> commands(StatefulRedisSentinelConnection<String, String> connection) {
        return connection.sync();
    }

}
