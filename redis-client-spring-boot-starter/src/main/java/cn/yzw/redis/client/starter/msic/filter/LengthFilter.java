package cn.yzw.redis.client.starter.msic.filter;

/**
 * @author w.dehai.2021/8/13.16:11
 */
public class LengthFilter {

    public String process(String source, int length) {
        if (source.length() > length) {
            throw new IllegalArgumentException(source + "长度超过超过" + length + "个字节");
        }
        return source;
    }
}
