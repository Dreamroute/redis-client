package cn.yzw.redis.client.sample.template;

import cn.yzw.redis.client.starter.client.RedisClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author w.dehai.2021/8/11.18:10
 */
@SpringBootTest
class LettuceTest {

    @Resource
    private RedisClient redisClient;

    @Test
    void mmm() {
        redisClient.set("nd", "nvvvvvd", 100);
        String v = redisClient.get("nd");
        System.err.println(v);
        redisClient.delete("nd");
    }

    @Test
    void delTest() {

    }

}
