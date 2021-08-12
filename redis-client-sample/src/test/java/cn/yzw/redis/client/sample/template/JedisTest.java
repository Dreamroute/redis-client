//package cn.yzw.redis.client.sample.template;
//
//import cn.yzw.redis.client.starter.msic.Type;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import redis.clients.jedis.HostAndPort;
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisCluster;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//import redis.clients.jedis.JedisSentinelPool;
//import redis.clients.jedis.commands.JedisClusterCommands;
//import redis.clients.jedis.commands.JedisCommands;
//
//import java.util.HashSet;
//import java.util.Objects;
//
//import static cn.yzw.redis.client.starter.msic.Type.CLUSTER;
//import static cn.yzw.redis.client.starter.msic.Type.SENTINEL;
//import static cn.yzw.redis.client.starter.msic.Type.STANDALONE;
//
//@Slf4j
//class JedisTest {
//
//    private Type type;
//    private String host;
//    private int port;
//
//    @Test
//    void nnnn() {
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(3);
//        config.setMaxIdle(3);
//        config.setMinIdle(3);
//
//        JedisPool pool = new JedisPool(config, "172.16.1.55", 6379);
//        for (int i = 0; i < 50; i++) {
//            Jedis resource = pool.getResource();
//            System.err.println(resource);
//            resource.setex("name", 5, "w.dehai");
//            resource.close();
//        }
//    }
//
//    @Test
//    void qqq() {
//        JedisPoolConfig config = new JedisPoolConfig();
//        config.setMaxTotal(3);
//        config.setMaxIdle(3);
//        config.setMinIdle(3);
//        JedisCluster cluster = new JedisCluster(new HostAndPort("172.16.1.55", 6379));
//        for (int i = 0; i < 50; i++) {
//            cluster.setex("name", 5, "w.d3ehai");
//        }
//    }
//
//    @Test
//    void mmmmm() {
//
//
//        if (Objects.equals(type, STANDALONE)) {
//            JedisPoolConfig config = new JedisPoolConfig();
//            config.setMaxTotal(10);
//            config.setMaxIdle(10);
//            config.setMaxWaitMillis(100 * 1000);
//            config.setTestOnBorrow(true);
//            JedisPool jedisPool = new JedisPool(config, host, port);
//            Jedis resource = jedisPool.getResource();
//
//
//
//        } else if (Objects.equals(type, SENTINEL)) {
//            JedisSentinelPool sentinel;
////            Jedis resource = sentinel.getResource();
//
//
//        } else if (Objects.equals(type, CLUSTER)) {
//            JedisCluster cluster;
////            cluster.set("k", "v");
//            JedisCluster jedisCluster = new JedisCluster(new HashSet<>());
//
//
//        }
//
//        GenericObjectPoolConfig jedisPoolConfig = new GenericObjectPoolConfig();
//        JedisCommands jc;
//
//
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "172.16.1.55", 6379, 3000);
////        new jedispo
//        Jedis jedis = null;
//        try {
//            jedis = jedisPool.getResource();
//            //具体的命令
//            jedis.set("dd", "mm");
//        } catch (Exception e) {
//            log.error(e.getMessage(), e);
//        } finally {
//            //在 JedisPool 模式下，Jedis 会被归还给资源池
//            if (jedis != null)
//                jedis.close();
//        }
//
//    }
//}
