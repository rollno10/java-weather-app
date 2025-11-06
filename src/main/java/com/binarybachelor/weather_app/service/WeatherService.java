package com.binarybachelor.weather_app.service;

import org.springframework.stereotype.Service;
import com.binarybachelor.weather_app.external.GeocodeApi;
import com.binarybachelor.weather_app.external.WeatherBitApi;
import com.binarybachelor.weather_app.external.RainViewerApi;
import com.binarybachelor.weather_app.external.WeatherApi;
import org.springframework.beans.factory.annotation.Autowired;

import com.binarybachelor.weather_app.dto.CurrentWeatherDto;
import com.binarybachelor.weather_app.dto.ForcastWeatherDto;
import com.binarybachelor.weather_app.dto.GeoCodeDto;
import com.binarybachelor.weather_app.dto.RadarMapDto;
import com.binarybachelor.weather_app.dto.HourlyWeatherDto;
import com.binarybachelor.weather_app.service.RedisService;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;


@Service
public class  WeatherService {

  @Autowired
  private GeocodeApi geocodeApi;
  @Autowired
  private WeatherBitApi weatherBitApi;
  @Autowired
  private RainViewerApi rainViewerApi;
  @Autowired
  private WeatherApi weatherApi;
  @Autowired
  private RedisService redisService;

  public GeoCodeDto getGeoCode(String city){

    String key = "geocode:"+city;

    GeoCodeDto cache = redisService.getWeather(key, GeoCodeDto.class);
    if(cache != null){
      return cache;
    }
    GeoCodeDto geoCode = geocodeApi.callGeoCodeApi(city);
    redisService.saveWeather(key,geoCode);
    return geoCode;
    
  }

  public CurrentWeatherDto getCurrentWeather(String api_key, String lat, String lon,String city){
    
    String key = "currentWeather:"+city;
    
    CurrentWeatherDto cache = redisService.getWeather(key, CurrentWeatherDto.class);
    if(cache != null){
      return cache;
    }
    CurrentWeatherDto currentWeather = weatherBitApi.callCurrentWeatherBitApi(api_key,lat,lon);
    redisService.saveWeatherWithTTL(key,currentWeather,300);
    return currentWeather;
    
  }

  public List<ForcastWeatherDto> getForecastWeather(String api_key, String lat, String lon, String city){

    String key = "forecastWeather:"+city;
      
      List<ForcastWeatherDto> cache = redisService.getWeather(key, new TypeReference<List<ForcastWeatherDto>>(){});
      if(cache != null){
        return cache;
      }
    List<ForcastWeatherDto> forcastWeather =  weatherBitApi.callForecastWeatherApi(api_key,lat,lon);
    redisService.saveWeatherWithTTL(key,forcastWeather,10800);
    return forcastWeather;
  }

  public RadarMapDto getRadarMap(){

    String key = "radarMap";

    RadarMapDto cache = redisService.getWeather(key, RadarMapDto.class);
    if(cache != null){
      return cache;
    }
    RadarMapDto radarMap = rainViewerApi.callRainViewerApi();
    redisService.saveWeatherWithTTL(key,radarMap,180);
    return radarMap;
  }

  public List<HourlyWeatherDto> getHourlyWeather(String api_key, String city){

    String key = "hourlyWeather:"+city;

      List<HourlyWeatherDto> cache = redisService.getWeather(key, new TypeReference<List<HourlyWeatherDto>>(){});
      if(cache != null) {
        return cache;
      }
      List<HourlyWeatherDto> hourlyWeather = weatherApi.callHourlyWeatherApi(api_key,city);
      redisService.saveWeatherWithTTL(key,hourlyWeather,1800);
      return hourlyWeather;
  }

}