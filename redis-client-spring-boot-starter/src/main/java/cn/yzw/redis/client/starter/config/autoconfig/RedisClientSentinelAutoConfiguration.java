package cn.yzw.redis.client.starter.config.autoconfig;

import cn.yzw.redis.client.starter.config.RedisClientProperites;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.masterreplica.MasterReplica;
import io.lettuce.core.masterreplica.StatefulRedisMasterReplicaConnection;
import io.lettuce.core.resource.ClientResources;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

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
        RedisURI uri = RedisURI.builder()
                .withSentinel(properites.getHost(), properites.getPort())
                .withSentinelMasterId(properites.getSentinel().getMasterId())
                .build();
        uri.setDatabase(properites.getDatabase());
        uri.setTimeout(Duration.of(properites.getTimeout(), ChronoUnit.SECONDS));
        if (!StringUtils.isEmpty(properites.getPassword())) {
            uri.setPassword(properites.getPassword());
        }
        return uri;
    }

    @Bean(destroyMethod = "shutdown")
    public RedisClient client(ClientResources clientResources, RedisURI uri) {
        return RedisClient.create(clientResources, uri);
    }

    @Bean(destroyMethod = "close")
    public StatefulRedisMasterReplicaConnection<String, String> connection(RedisClient client, RedisURI uri) {
        return MasterReplica.connect(client, StringCodec.UTF8, uri);
    }

    @Bean
    public RedisCommands<String, String> commands(StatefulRedisMasterReplicaConnection<String, String> connection) {
        return connection.sync();
    }

}
