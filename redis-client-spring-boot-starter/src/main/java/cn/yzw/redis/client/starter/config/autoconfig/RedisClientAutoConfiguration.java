package cn.yzw.redis.client.starter.config.autoconfig;

import cn.yzw.redis.client.starter.config.RedisClientProperites;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.resource.ClientResources;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author w.dehai.2021/8/2.16:03
 */
@RequiredArgsConstructor
public abstract class RedisClientAutoConfiguration {

    private final RedisClientProperites properites;

    public RedisURI baseUri() {
        RedisURI uri = new RedisURI();
        uri.setHost(properites.getHost());
        uri.setPort(properites.getPort());
        uri.setDatabase(properites.getDatabase());
        if (!StringUtils.isEmpty(properites.getPassword())) {
            uri.setPassword(properites.getPassword());
        }
        uri.setTimeout(Duration.of(properites.getTimeout(), ChronoUnit.SECONDS));
        return uri;
    }

    @Bean(destroyMethod = "shutdown")
    public ClientResources clientResources() {
        return ClientResources.create();
    }

    public RedisURI uri() {
        return baseUri();
    }

    public RedisClient client(ClientResources clientResources, RedisURI uri) {
        return RedisClient.create(clientResources, uri);
    }

    public StatefulRedisConnection<String, String> connection(RedisClient client) {
        return client.connect();
    }

    public RedisCommands<String, String> commands(StatefulRedisConnection<String, String> connection) {
        return connection.sync();
    }

//
//    /**
//     * 主从
//     */
//    @Bean
//    @ConditionalOnProperty(prefix = REDIS_CLIENT_PREFIX, value = "server", havingValue = "replica")
//    public RedisURI replicaUri() {
//        return baseUri();
//    }
//
//    /**
//     * 哨兵
//     */
//    @Bean
//    @ConditionalOnProperty(prefix = REDIS_CLIENT_PREFIX, value = "server", havingValue = "sentinel")
//    public RedisURI sentinelUri() {
//        RedisURI uri = baseUri();
//        String masterId = properites.getSentinel().getMasterId();
//        if (StringUtils.isEmpty(masterId)) {
//            throw new IllegalArgumentException("哨兵模式下需要设置masterId");
//        }
//        uri.setSentinelMasterId(masterId);
//        return uri;
//    }
//
//    /**
//     * 集群
//     */
//    @Bean
//    @ConditionalOnProperty(prefix = REDIS_CLIENT_PREFIX, value = "server", havingValue = "cluster")
//    public RedisURI clusterUri() {
//        return baseUri();
//    }
//
//    /**
//     * 单机
//     */
//    @Bean(destroyMethod = "shutdown")
//    public RedisClient client(ClientResources clientResources, RedisURI standaloneUri) {
//        return RedisClient.create(clientResources, standaloneUri);
//    }
//
//    /**
//     * 单机
//     */
//    @Bean(destroyMethod = "close")
//    @ConditionalOnProperty(prefix = REDIS_CLIENT_PREFIX, value = "server", havingValue = "standalone")
//    public StatefulRedisConnection<String, String> connection(RedisClient client) {
//        return client.connect();
//    }
//
//    /**
//     * 单机
//     */
//    @Bean
//    @ConditionalOnProperty(prefix = REDIS_CLIENT_PREFIX, value = "server", havingValue = "standalone")
//    public RedisCommands<String, String> commands(StatefulRedisConnection<String, String> connection) {
//        return connection.sync();
//    }

}
