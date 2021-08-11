package cn.yzw.redis.client.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import static cn.yzw.redis.client.starter.config.RedisClientProperites.REDIS_CLIENT_PREFIX;

/**
 * @author w.dehai.2021/8/2.16:02
 */
@Data
@ConfigurationProperties(REDIS_CLIENT_PREFIX)
public class RedisClientProperites {
    private RedisClientProperites() {}

    static final String REDIS_CLIENT_PREFIX = "redis.client";

    private String host = "localhost";
    private int port = 6379;
    private String password;

    private Standalone standalone;
    private Replica replica;
    private Sentinel sentinel;
    private Cluster cluster;

    @Data
    public static class Standalone {}

    @Data
    public static class Replica {}

    @Data
    public static class Sentinel {
        private String master;
    }

    @Data
    public static class Cluster {}

}
