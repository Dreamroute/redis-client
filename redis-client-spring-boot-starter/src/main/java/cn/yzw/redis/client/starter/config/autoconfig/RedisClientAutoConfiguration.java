package cn.yzw.redis.client.starter.config.autoconfig;

import cn.yzw.redis.client.starter.client.RedisClient;
import cn.yzw.redis.client.starter.client.RedisClientImpl;
import cn.yzw.redis.client.starter.config.RedisClientProperites;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.sync.RedisStringCommands;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author w.dehai.2021/8/12.11:50
 */
@AutoConfigureAfter({
        RedisClientStandaloneAutoConfiguration.class,
        RedisClientReplicaAutoConfiguration.class,
        RedisClientSentinelAutoConfiguration.class,
        RedisClientClusterAutoConfiguration.class
})
@ConditionalOnClass(RedisURI.class)
@EnableConfigurationProperties(RedisClientProperites.class)
public class RedisClientAutoConfiguration {

    private final RedisClientProperites properites;
    private final RedisStringCommands<String, String> commands;

    public RedisClientAutoConfiguration(RedisClientProperites properites, ObjectProvider<RedisStringCommands<String, String>> commands) {
        this.properites = properites;
        this.commands = commands.getIfUnique();
    }

    @Bean
    public RedisClient redisClient() {
        return new RedisClientImpl(properites, commands);
    }

}
