package cn.yzw.redis.client.starter.config.autoconfig;

import cn.yzw.redis.client.starter.config.RedisClientProperites;
import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.sync.RedisClusterCommands;
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
@ConditionalOnProperty(prefix = RedisClientProperites.REDIS_CLIENT_PREFIX, value = "server", havingValue = "cluster")
public class RedisClientClusterAutoConfiguration extends RedisClientBaseConfig {

    public RedisClientClusterAutoConfiguration(RedisClientProperites properites) {
        super(properites);
    }

    @Bean
    @Override
    public RedisURI uri() {
        return super.baseUri();
    }

    @Bean(destroyMethod = "shutdown")
    public RedisClusterClient client(ClientResources clientResources, RedisURI uri) {
        return RedisClusterClient.create(clientResources, uri);
    }

    @Bean(destroyMethod = "close")
    public StatefulRedisClusterConnection<String, String> connection(RedisClusterClient client) {
        return client.connect();
    }

    @Bean
    public RedisClusterCommands<String, String> commands(StatefulRedisClusterConnection<String, String> connection) {
        return connection.sync();
    }

}
