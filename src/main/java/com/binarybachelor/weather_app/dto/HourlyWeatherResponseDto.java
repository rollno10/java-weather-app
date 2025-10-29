package com.binarybachelor.weather_app.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.binarybachelor.weather_app.dto.ForecastDto;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class  HourlyWeatherResponseDto{

  private ForecastDto forecast;

  public ForecastDto getForecast(){
    return forecast;
  }

  public void setForecast(ForecastDto forecast){
    this.forecast = forecast;
  }
}