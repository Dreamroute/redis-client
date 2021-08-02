package cn.yzw.redis.client.sample.template;

import cn.yzw.redis.client.starter.client.RedisClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author w.dehai.2021/8/2.16:54
 */
@SpringBootTest
class RedisClientTest {

    @Resource
    private RedisClient redisClient;

    @Test
    void setTest() {
        String name = "wkk";
        redisClient.set("name", name);
        String v = redisClient.get("name");
        assertEquals(name, v);
    }

}
