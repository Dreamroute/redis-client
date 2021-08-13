package cn.yzw.redis.client.starter.msic.filter;

import java.util.Arrays;

/**
 * @author w.dehai.2021/8/13.16:35
 */
public class SpecialCharacterFilter {

    public String process(String source, String specialCharacter) {
        String[] split = specialCharacter.split(",");
        if (split.length == 0) {
            return source;
        }
        boolean present = Arrays.stream(split).map(String::trim).anyMatch(source::contains);
        if (present) {
            throw new IllegalArgumentException(source + "存在特殊字符");
        }
        return source;
    }
}
