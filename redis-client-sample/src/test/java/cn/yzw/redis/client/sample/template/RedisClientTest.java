package cn.yzw.redis.client.sample.template;

import cn.yzw.redis.client.starter.client.RedisClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * @author w.dehai.2021/8/2.16:54
 */
@SpringBootTest
class RedisClientTest {

    @Resource
    private RedisClient redisClient;

    private static final String K = "name";
    private static final String V = "wkk";

    @BeforeEach
    void clearKey() {
        redisClient.delete(K);
    }

    @Test
    void setTest() {
        redisClient.set(K, V, 10);
        String v = redisClient.get(K);
        assertEquals(V, v);
    }

    @Test
    void setNxTest() throws Exception {
        redisClient.set(K, V, 3);
        redisClient.setNx(K, V, 3);
        SECONDS.sleep(4);
        redisClient.setNx(K, V, 3);
    }

    @Test
    void deleteTest() {
        redisClient.set(K, V, 50);
        Long delete = redisClient.delete(K);
        String v = redisClient.get(K);
        assertEquals(1L, delete);
        assertNull(v);
    }

}
