package com.binarybachelor.weather_app.service;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.annotation.PostConstruct;
import org.springframework.data.redis.core.RedisTemplate;
import java.time.Duration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;


@Service
public class  RedisService{

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  public <T> void saveWeather(String key, T value){

    try{
      String json = objectMapper.writeValueAsString(value);
      redisTemplate.opsForValue().set(key, json);
    } catch(JsonProcessingException e) {
      throw new RuntimeException("Serialization failed");
    }
  }

  public <T> T getWeather(String key, TypeReference<T> typeRef){

        String json = redisTemplate.opsForValue().get(key);
        if(json != null){
          try{
          return objectMapper.readValue(json, typeRef);
          } catch(JsonProcessingException e){
            throw new RuntimeException("Deserialization failed");
          }
        }
        return null;
  }
  
  public <T> T getWeather(String key, Class<T> clazz){

        String json = redisTemplate.opsForValue().get(key);
        if(json != null){
          try{
          return objectMapper.readValue(json, clazz);
          } catch(JsonProcessingException e){
            throw new RuntimeException("Deserialization failed");
          }
        }
        return null;
  }

  public <T> void saveWeatherWithTTL(String key, T value, long ttlSeconds){
    
    try{
      String json = objectMapper.writeValueAsString(value);
      redisTemplate.opsForValue().set(key, json, Duration.ofSeconds(ttlSeconds));
    } catch(JsonProcessingException e){
      throw new RuntimeException("Serialization failed");
    }
  }
}