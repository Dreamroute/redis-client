package cn.yzw.redis.client.starter.config.autoconfig;

import cn.yzw.redis.client.starter.config.RedisClientProperites;
import io.lettuce.core.RedisURI;
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
public abstract class RedisClientBaseConfig {

    protected final RedisClientProperites properites;

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

    public abstract RedisURI uri();

}
