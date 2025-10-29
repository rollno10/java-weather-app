package com.binarybachelor.weather_app.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.binarybachelor.weather_app.dto.HourlyWeatherDto;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class  ForecastDayDto{

  private List<HourlyWeatherDto> hour;

  public List<HourlyWeatherDto> getHour(){
    return hour;
  }

  public void setHour(List<HourlyWeatherDto> hour){
    this.hour = hour;
  }
}