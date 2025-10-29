package com.binarybachelor.weather_app.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.binarybachelor.weather_app.dto.ForecastDayDto;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class  ForecastDto{

  private List<ForecastDayDto> forecastday;

  public List<ForecastDayDto> getForecastday(){
    return forecastday;
  }

  public void setForecastday(List<ForecastDayDto> forecastday){
    this.forecastday = forecastday;
  }
}