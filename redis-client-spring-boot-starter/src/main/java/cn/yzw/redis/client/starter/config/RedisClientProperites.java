package cn.yzw.redis.client.starter.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author w.dehai.2021/8/2.16:02
 */
@Data
@ConfigurationProperties(RedisClientProperites.REDIS_CLIENT_PREFIX)
public class RedisClientProperites {
    private RedisClientProperites() {}

    public static final String REDIS_CLIENT_PREFIX = "redis.client";

    private Server server;

    /**
     * 服务器地址
     */
    private String host = "localhost";

    /**
     * 端口
     */
    private int port = 6379;

    /**
     * 密码
     */
    private String password;

    /**
     * 数据库序号
     */
    private int database = 0;

    /**
     * 单位：秒
     */
    private int timeout = 60;

    /**
     * key的最大长度（单位：byte），默认512
     */
    private int keyLength = 512;

    /**
     * value的最大长度（单位：byte），默认1024
     */
    private int valueLength = 1024;

    /**
     * 不允许key和value存在的特殊字符
     */
    private String specialCharacter;

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
        private String masterId;
    }

    @Data
    public static class Cluster {}

}
