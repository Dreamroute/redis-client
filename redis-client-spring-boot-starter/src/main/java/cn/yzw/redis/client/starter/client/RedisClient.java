package cn.yzw.redis.client.starter.client;

import cn.hutool.core.util.RandomUtil;

/**
 * @author w.dehai.2021/8/2.16:01
 */
public interface RedisClient {

    /**
     * 固定过期时间
     */
    void set(String k, String v, long expire);

    /**
     * 固定过期时间
     */
    void setNx(String k, String v, long expire);

    /**
     * 批量删除
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

    /**
     * 创建随机事件
     * @param startExpire 起始值
     * @param endExpire 结束值
     * @return 返回随机事件
     */
    default long createExpire(long startExpire, long endExpire) {
        if (startExpire > endExpire) {
            throw new IllegalArgumentException("起始时间不能大于截至时间");
        }
        return RandomUtil.randomLong(startExpire, endExpire);
    }

}
