package cn.yzw.redis.client.sample.template;

import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RedissonTest {

    @Test
    void mm() {
        RedissonClient redissonClient = Redisson.create();

    }

}
