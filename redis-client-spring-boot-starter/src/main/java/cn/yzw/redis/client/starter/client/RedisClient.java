package cn.yzw.redis.client.starter.client;

/**
 * @author w.dehai.2021/8/2.16:01
 */
public interface RedisClient {

    /**
     * 设置k, v
     *
     * @param k key
     * @param v value
     * @param expire 过期时间，单位秒
     */
    void set(String k, String v, long expire);

    /**
     * 设置k, v（k不存在时）
     *
     * @param k key
     * @param v value
     * @param expire 过期时间，单位秒
     */
    void setNx(String k, String v, long expire);

    /**
     * 批量删除
     * @param keys k列表
     *
     * @return 返回被删除的个数
     */
    Long delete(String... keys);

    /**
     * 查询
     *
     * @param k key
     * @return value
     */
    String get(String k);

}
