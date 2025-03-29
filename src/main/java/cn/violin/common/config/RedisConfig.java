package cn.violin.common.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@Data
@Slf4j
public class RedisConfig {

    @Value("${violin.redis.host}")
    private String host;

    @Value("${violin.redis.port}")
    private int port;

    @Value("${violin.redis.database}")
    private int database;

    @Value("${violin.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${violin.redis.pool.min-idle}")
    private int minIdle;

    @Value("${violin.redis.pool.max-active}")
    private int maxActive;

    @Value("${violin.redis.password}")
    private String password;

    @Value("${violin.redis.timeout}")
    private int timeout;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxActive);


        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password, database);

        Jedis jedis = jedisPool.getResource();
        log.info(jedis.ping());
        log.info("JedisPool连接成功:{}\t{}", host, port);
        jedis.close();
        return jedisPool;
    }

}
