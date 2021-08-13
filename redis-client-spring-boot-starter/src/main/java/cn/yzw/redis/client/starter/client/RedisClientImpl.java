package cn.yzw.redis.client.starter.client;

import io.lettuce.core.SetArgs;
import io.lettuce.core.api.sync.RedisKeyCommands;
import io.lettuce.core.api.sync.RedisStringCommands;
import lombok.AllArgsConstructor;

import java.util.Collection;

/**
 * 客户端实现类，单机、主从、哨兵、集群整合成一个客户端
 *
 * @author wangdehai
 */
@AllArgsConstructor
public class RedisClientImpl implements RedisClient {

    private final RedisStringCommands<String, String> commands;

    /**
     * 固定过期时间
     *
     * @param k key
     * @param v value
     * @param expire 过期时间，单位秒
     */
    @Override
    public void set(String k, String v, long expire) {
        commands.setex(k, expire, v);
    }

    /**
     * 随机过期时间
     *
     * @param k key
     * @param v value
     * @param startExpire 过期时间最小值
     * @param endExpire 过期时间最大值
     */
    @Override
    public void set(String k, String v, long startExpire, long endExpire) {
        set(k, v, createExpire(startExpire, endExpire));
    }

    /**
     * 固定过期时间
     */
    @Override
    public void setNx(String k, String v, long expire) {
        SetArgs args = SetArgs.Builder.nx().ex(expire);
        commands.set(k, v, args);
    }

    /**
     * 随机过期时间
     */
    @Override
    public void setNx(String k, String v, long startExpire, long endExpire) {
        setNx(k, v, createExpire(startExpire, endExpire));
    }

    /**
     * 查询
     *
     * @param k key
     * @return value
     */
    @Override
    public String get(String k) {
        return commands.get(k);
    }

    @Override
    public Boolean delete(String k) {
        RedisKeyCommands<String, String> keyCommands = (RedisKeyCommands<String, String>) commands;
        keyCommands.del("dd");
        return null;
    }

    @Override
    public Long delete(Collection<String> keys) {
        RedisKeyCommands<String, String> keyCommands = (RedisKeyCommands<String, String>) commands;
        keyCommands.del(keys.toArray(new String[0]));
        return null;
    }
}
