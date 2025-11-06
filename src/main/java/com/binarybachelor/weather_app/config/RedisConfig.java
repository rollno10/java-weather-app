package com.binarybachelor.weather_app.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class  RedisConfig{

  @Bean
  public RedisConnectionFactory redisConnectionFactory() {
      RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
      config.setHostName(System.getenv("SPRING_REDIS_HOST"));
      config.setPort(Integer.parseInt(System.getenv("SPRING_REDIS_PORT")));
      config.setPassword(RedisPassword.of(System.getenv("SPRING_REDIS_PASSWORD")));

      LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
          .build();

      return new LettuceConnectionFactory(config, clientConfig);
  }


  @Bean
  public RedisTemplate<String, String> redisTemplate(){

    RedisTemplate<String, String> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory());

    // Set the key serializer to StringRedisSerializer
    template.setKeySerializer(new StringRedisSerializer());

    // Set the value serializer to Jackson2JsonRedisSerializer
    template.setValueSerializer(new StringRedisSerializer());  
    return template;
  }
}