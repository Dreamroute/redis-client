package cn.yzw.redis.client.starter.msic.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author w.dehai.2021/8/13.17:07
 */
class SpecialCharacterValidatorTest {

    @Test
    void processTest() {
        SpecialCharacterValidator validator = new SpecialCharacterValidator();
        assertThrows(IllegalArgumentException.class, () -> validator.process("name{", "{"));
    }

}
