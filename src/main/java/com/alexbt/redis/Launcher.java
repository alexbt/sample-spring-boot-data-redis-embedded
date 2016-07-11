package com.alexbt.redis;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories
public class Launcher {
	
	public static void main(String[] args){
		new SpringApplicationBuilder() //
		.sources(Launcher.class)//
		.run(args);
	}
	
	@Bean
    public RedisTemplate<String, Model> redisTemplate() {
		RedisTemplate<String, Model> redisTemplate = new RedisTemplate<String, Model>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());

        return redisTemplate;
    }
	
	
	@Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("localhost");
        return jedisConnectionFactory;
    }
}
