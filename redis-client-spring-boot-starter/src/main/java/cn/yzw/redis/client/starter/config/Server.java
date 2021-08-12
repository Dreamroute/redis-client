package cn.yzw.redis.client.starter.config;

/**
 * @author w.dehai.2021/8/12.10:16
 */
public enum Server {

    /**
     * 单机
     */
    STANDALONE,

    /**
     * 主从
     */
    REPLICA,

    /**
     * 哨兵
     */
    SENTINEL,

    /**
     * 集群
     */
    CLUSTER;
}
