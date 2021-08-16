package cn.yzw.redis.client.starter.msic.validator;

import org.springframework.util.StringUtils;

import java.util.Arrays;

/**
 * @author w.dehai.2021/8/13.16:35
 */
public class SpecialCharacterValidator {

    public void process(String source, String specialCharacter) {
        if (!StringUtils.isEmpty(specialCharacter)) {
            String[] split = specialCharacter.split(",");
            if (split.length > 0) {
                boolean present = Arrays.stream(split).map(String::trim).anyMatch(source::contains);
                if (present) {
                    throw new IllegalArgumentException(source + "存在特殊字符");
                }
            }
        }
    }
}
