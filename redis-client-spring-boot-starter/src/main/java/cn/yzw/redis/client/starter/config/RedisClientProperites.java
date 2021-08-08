package cn.yzw.redis.client.starter.config;

import cn.yzw.redis.client.starter.msic.Type;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Set;

import static cn.yzw.redis.client.starter.config.RedisClientProperites.REDIS_CLIENT_PREFIX;
import static cn.yzw.redis.client.starter.msic.Type.STANDALONE;

/**
 * @author w.dehai.2021/8/2.16:02
 */
@Data
@ConfigurationProperties(REDIS_CLIENT_PREFIX)
public class RedisClientProperites {

    static final String REDIS_CLIENT_PREFIX = "redis.client";

    /**
     * 集群模式
     */
    private Type type = STANDALONE;

    /**
     * 主机地址列表，ip: port
     */
    private Set<String> nodes;

    /**
     * 主节点名称，哨兵模式下生效，单机和集群无效
     */
    private String masterName;

    /**
     * 密码
     */
    private String password;

    /**
     * 连接池
     */
    private Pool pool;

    @Data
    public static class Pool {
        private int maxTotal = 10;
        private int maxIdle = 10;
        private int minIdle = 10;
        private int maxActive = 10;
    }

}
