package cn.violin.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
public class JedisUtils {

    @Autowired
    private JedisPool jedisPool;

    public Optional<String> get(String key) {
        Jedis jedis = jedisPool.getResource();
        String value = jedis.get(key);
        jedis.close();
        return Optional.ofNullable(value);
    }

    public String set(String key, String value, int unit, TimeUnit timeout) {
        Jedis jedis = jedisPool.getResource();
        SetParams params = SetParams.setParams();
        String statusCode = jedis.set(key, value, params);
        jedis.close();
        return statusCode;
    }

    public Long delete (String key) {
        Jedis jedis = jedisPool.getResource();
        Long statusCode = jedis.del(key);
        jedis.close();
        return statusCode;
    }

}
