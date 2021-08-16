package cn.yzw.redis.client.starter.client;

import cn.yzw.redis.client.starter.config.RedisClientProperites;
import cn.yzw.redis.client.starter.msic.validator.LengthValidator;
import cn.yzw.redis.client.starter.msic.validator.SpecialCharacterValidator;
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

    private final LengthValidator lengthValidator = new LengthValidator();
    private final SpecialCharacterValidator specialCharacterValidator = new SpecialCharacterValidator();

    @Override
    public void set(String k, String v, long expire) {
        lengthValidator.process(k, properites.getKeyLength());
        lengthValidator.process(v, properites.getValueLength());
        specialCharacterValidator.process(k, properites.getSpecialCharacter());
        specialCharacterValidator.process(v, properites.getSpecialCharacter());
        commands.setex(k, expire, v);
    }

    @Override
    public void setNx(String k, String v, long expire) {
        lengthValidator.process(k, properites.getKeyLength());
        lengthValidator.process(v, properites.getValueLength());
        specialCharacterValidator.process(k, properites.getSpecialCharacter());
        specialCharacterValidator.process(v, properites.getSpecialCharacter());
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
