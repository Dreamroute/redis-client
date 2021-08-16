package cn.yzw.redis.client.starter.msic.validator;

import org.junit.jupiter.api.Test;

/**
 * @author w.dehai.2021/8/13.16:53
 */
class LengthValidatorTest {

    @Test
    void processTest() {
        LengthValidator lengthValidator = new LengthValidator();
        lengthValidator.process("name", 3);
    }

}
