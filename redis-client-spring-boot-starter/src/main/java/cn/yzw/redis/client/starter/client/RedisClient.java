package cn.yzw.redis.client.starter.client;

import cn.hutool.core.util.RandomUtil;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * @author w.dehai.2021/8/2.16:01
 */
public interface RedisClient {

    /**
     * 固定过期时间
     */
    void set(String k, String v, int expire, TimeUnit unit);

    /**
     * 随机过期时间
     *
     * @param k key
     * @param v value
     * @param startExpire 过期时间最小值
     * @param endExpire 过期时间最大值
     * @param unit 过期时间单位
     */
    void set(String k, String v, int startExpire, int endExpire, TimeUnit unit);

    /**
     * 固定过期时间
     */
    Boolean setNx(String k, String v, int expire, TimeUnit unit);

    /**
     * 随机过期时间
     *
     */
    Boolean setNx(String k, String v, int startExpire, int endExpire, TimeUnit unit);

    /**
     * 删除单个key
     *
     * @param k key
     * @return 删除成功返回True，否则返回False
     */
    Boolean delete(String k);

    /**
     * 批量删除
     *
     * @return 返回被删除的个数
     */
    Long delete(Collection<String> keys);

    /**
     * 查询
     *
     * @param k key
     * @return value
     */
    String get(String k);

    default int createExpire(int startExpire, int endExpire) {
        if (startExpire > endExpire) {
            throw new IllegalArgumentException("起始时间不能大于截至时间");
        }
        return RandomUtil.randomInt(startExpire, endExpire);
    }

}
