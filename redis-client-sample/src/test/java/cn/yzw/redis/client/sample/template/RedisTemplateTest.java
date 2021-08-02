package cn.yzw.redis.client.sample.template;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author w.dehai.2021/8/2.16:17
 */
@SpringBootTest
class RedisTemplateTest {

    @Resource
    private RedisTemplate<String, String> client;

    @Test
    void setTest() {
        String name = "w.dehai";
        client.opsForValue().set("name", name);
        String value = client.opsForValue().get("name");
        assertEquals(name, value);
    }

    @Test
    void serializableTest() {
        client.opsForValue().set
    }

}
