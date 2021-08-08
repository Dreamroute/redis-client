package cn.yzw.redis.client.starter.msic;

/**
 * 服务端模式，单机或者哨兵或者集群
 *
 * @author w.dehai
 */
public enum Type {
    /**
     * 单机，默认
     */
    STANDALONE,

    /**
     * 哨兵
     */
    SENTINEL,

    /**
     * 集群
     */
    CLUSTER
}
