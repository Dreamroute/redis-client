package cn.yzw.redis.client.sample.template;

import cn.yzw.redis.client.starter.client.RedisClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        redisClient.set(K, V, 10, SECONDS);
        String v = redisClient.get(K);
        assertEquals(V, v);
    }

    @Test
    void setRamdomExpireTest() throws Exception {
        redisClient.set(K, V, 3, 6, SECONDS);
        assertEquals(V, redisClient.get(K));
        SECONDS.sleep(3);
        assertEquals(V, redisClient.get(K));
        SECONDS.sleep(3);
        assertNull(redisClient.get(K));
    }

    @Test
    void setNxTest() throws Exception {
        redisClient.set(K, V, 3, SECONDS);
        assertFalse(redisClient.setNx(K, V, 3, SECONDS));
        SECONDS.sleep(4);
        assertTrue(redisClient.setNx(K, V, 3, SECONDS));
    }

}
