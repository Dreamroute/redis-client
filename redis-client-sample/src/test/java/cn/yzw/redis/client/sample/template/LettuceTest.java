package cn.yzw.redis.client.sample.template;

import io.lettuce.core.api.sync.RedisCommands;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author w.dehai.2021/8/11.18:10
 */
@SpringBootTest
class LettuceTest {

    @Resource
    private RedisCommands<String, String> commands;

    @Test
    void mmm() {
        for (int i = 0; i < 5; i++) {
            commands.set("sdd" + i, "mm" + i);
        }
    }

}
