package cn.yzw.redis.client.starter.msic.filter;

import org.junit.jupiter.api.Test;

/**
 * @author w.dehai.2021/8/13.16:53
 */
class LengthFilterTest {

    @Test
    void processTest() {
        LengthFilter lengthFilter = new LengthFilter();
        lengthFilter.process("name", 3);
    }

}
