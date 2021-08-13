package cn.yzw.redis.client.starter.client;

import cn.yzw.redis.client.starter.config.RedisClientProperites;
import cn.yzw.redis.client.starter.msic.filter.LengthFilter;
import cn.yzw.redis.client.starter.msic.filter.SpecialCharacterFilter;
import io.lettuce.core.SetArgs;
import io.lettuce.core.api.sync.RedisKeyCommands;
import io.lettuce.core.api.sync.RedisStringCommands;

/**
 * 客户端实现类，单机、主从、哨兵、集群整合成一个客户端
 *
 * @author wangdehai
 */
public class RedisClientImpl implements RedisClient {

    private final RedisClientProperites properites;
    private final RedisStringCommands<String, String> commands;

    public RedisClientImpl(RedisClientProperites properites, RedisStringCommands<String, String> commands) {
        this.properites = properites;
        this.commands = commands;
    }

    private final LengthFilter lengthFilter = new LengthFilter();
    private final SpecialCharacterFilter specialCharacterFilter = new SpecialCharacterFilter();

    /**
     * 固定过期时间
     *
     * @param k key
     * @param v value
     * @param expire 过期时间，单位秒
     */
    @Override
    public void set(String k, String v, long expire) {
        k = lengthFilter.process(k, properites.getKeyLength());
        v = lengthFilter.process(v, properites.getValueLength());
        k = specialCharacterFilter.process(k, properites.getSpecialCharacter());
        v = specialCharacterFilter.process(v, properites.getSpecialCharacter());
        commands.setex(k, expire, v);
    }

    /**
     * 固定过期时间
     */
    @Override
    public void setNx(String k, String v, long expire) {
        k = lengthFilter.process(k, properites.getKeyLength());
        v = lengthFilter.process(v, properites.getValueLength());
        k = specialCharacterFilter.process(k, properites.getSpecialCharacter());
        v = specialCharacterFilter.process(v, properites.getSpecialCharacter());
        SetArgs args = SetArgs.Builder.nx().ex(expire);
        commands.set(k, v, args);
    }

    @Override
    public String get(String k) {
        return commands.get(k);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Long delete(String... keys) {
        RedisKeyCommands<String, String> keyCommands = (RedisKeyCommands<String, String>) commands;
        return keyCommands.del(keys);
    }
}
