package com.binarybachelor.weather_app.service;
import com.binarybachelor.weather_app.dto.CurrentWeatherResponseDto;
import com.binarybachelor.weather_app.dto.CurrentWeatherDto;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class  CurrentWeatherService {

  private final RestClient restClient;
  
  public CurrentWeatherService(RestClient.Builder restClientBuilder){
    this.restClient = restClientBuilder.baseUrl("https://api.weatherbit.io/v2.0").build();
   }
  

  public CurrentWeatherDto getCurrentWeather(String API_KEY, String LAT, String LON){
    Map<String, String> params = Map.of("LAT", LAT, "LON", LON, "API_KEY", API_KEY);
     CurrentWeatherResponseDto response = restClient.get().uri("/current?lat={LAT}&lon={LON}&key={API_KEY}",params).retrieve().body(CurrentWeatherResponseDto.class);

    return response.getData().get(0);
   }
}