package cn.yzw.redis.client.starter.msic.filter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author w.dehai.2021/8/13.17:07
 */
class SpecialCharacterFilterTest {

    @Test
    void processTest() {
        SpecialCharacterFilter filter = new SpecialCharacterFilter();
        assertThrows(IllegalArgumentException.class, () -> filter.process("name{", "{"));
    }

}
