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

  public GeoCodeDto getGeoCode(String city){
    return geocodeApi.callGeoCodeApi(city);
  }

  public CurrentWeatherDto getCurrentWeather(String api_key, String lat, String lon){
    return weatherBitApi.callCurrentWeatherBitApi(api_key,lat,lon);
  }

  public List<ForcastWeatherDto> getForecastWeather(String api_key, String lat, String lon){
    return weatherBitApi.callForecastWeatherApi(api_key,lat,lon);
  }

  public RadarMapDto getRadarMap(){
    return rainViewerApi.callRainViewerApi();
  }

  public List<HourlyWeatherDto> getHourlyWeather(String api_key, String city){
    return weatherApi.callHourlyWeatherApi(api_key,city);
  }

}