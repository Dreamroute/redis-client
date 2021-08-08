package cn.yzw.redis.client.starter.client;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class RedisClientImpl implements RedisClient {

    private final RedisTemplate<String, String> client;

    /**
     * 固定过期时间
     *
     * @param k key
     * @param v value
     * @param expire 过期时间
     * @param unit 过期时间单位
     */
    @Override
    public void set(String k, String v, int expire, TimeUnit unit) {
        client.opsForValue().set(k, v, expire, unit);
    }

    /**
     * 随机过期时间
     *
     * @param k key
     * @param v value
     * @param startExpire 过期时间最小值
     * @param endExpire 过期时间最大值
     * @param unit 过期时间单位
     */
    @Override
    public void set(String k, String v, int startExpire, int endExpire, TimeUnit unit) {
        set(k, v, createExpire(startExpire, endExpire), unit);
    }

    /**
     * 固定过期时间
     */
    @Override
    public Boolean setNx(String k, String v, int expire, TimeUnit unit) {
        return client.opsForValue().setIfAbsent(k, v, expire, unit);
    }

    /**
     * 随机过期时间
     */
    @Override
    public Boolean setNx(String k, String v, int startExpire, int endExpire, TimeUnit unit) {
        return setNx(k, v, createExpire(startExpire, endExpire), unit);
    }

    /**
     * 查询
     *
     * @param k key
     * @return value
     */
    @Override
    public String get(String k) {
        return client.opsForValue().get(k);
    }

    @Override
    public Boolean delete(String k) {
        return client.delete(k);
    }

    @Override
    public Long delete(Collection<String> keys) {
        return client.delete(keys);
    }
}
