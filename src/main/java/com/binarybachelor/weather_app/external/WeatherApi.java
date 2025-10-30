package com.binarybachelor.weather_app.external;

import org.springframework.web.client.RestClient;
import com.binarybachelor.weather_app.dto.HourlyWeatherDto;
import com.binarybachelor.weather_app.dto.HourlyWeatherResponseDto;
import java.util.List;
import java.util.Map;

public class WeatherApi{

  private final RestClient hourlyWeatherRestClient;

  public WeatherApi(RestClient.Builder restClientBuilder){

    this.hourlyWeatherRestClient = restClientBuilder.baseUrl("https://api.weatherapi.com/v1").build();
    
  }

  public List<HourlyWeatherDto> callHourlyWeatherApi(String API_KEY, String CITY){

    Map<String, String> params = Map.of("CITY", CITY, "API_KEY", API_KEY);

    HourlyWeatherResponseDto response = hourlyWeatherRestClient
      .get()
      .uri("/forecast.json?key={API_KEY}&q={CITY}",params)
      .retrieve()
      .body(HourlyWeatherResponseDto.class);

     return response
       .getForecast()
       .getForecastday()
       .get(0)
       .getHour();
  }
  
}