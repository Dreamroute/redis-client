* 引入依赖
```xml
<dependency>
    <groupId>cn.yzw</groupId>
    <artifactId>redis-client-spring-boot-starter</artifactId>
    <version>最新版本</version>
</dependency>
```
* 使用：在应用中的任何地方注入如下对象即可：
* 配置文件说明：单机、集群、哨兵均只需要配置一个地址，客户端做了拓扑发现，无需配置多个地址
```java
@Resource
private RedisClient redisClient;
```
* 关于配置文件，类似如下，在IDE中输入`redis.client`打头的配置会有自动提示，按照提示配置即可
```
# 单机
#redis.client.server=standalone
#redis.client.host=172.16.1.55

# 集群
#redis.client.server=cluster
#redis.client.host=172.16.0.239
#redis.client.port=6379

# 哨兵
redis.client.server=sentinel
redis.client.host=172.16.0.239
redis.client.port=26301
redis.client.password=test123
redis.client.sentinel.master-id=mymaster
```
