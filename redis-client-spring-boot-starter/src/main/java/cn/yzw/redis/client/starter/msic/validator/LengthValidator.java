package cn.yzw.redis.client.starter.msic.validator;

/**
 * @author w.dehai.2021/8/13.16:11
 */
public class LengthValidator {

    public void process(String source, int length) {
        if (source.length() > length) {
            throw new IllegalArgumentException(source + "长度超过超过" + length + "个字节");
        }
    }
}
