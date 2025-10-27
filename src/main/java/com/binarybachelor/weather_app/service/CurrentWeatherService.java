package com.binarybachelor.weather_app.service;
import com.binarybachelor.weather_app.dto.CurrentWeatherDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class  CurrentWeatherService {

  private final RestClient restClient;
  private final String API_KEY;
  private final String LAT;
  private final String LON;
  
  public CurrentWeatherService(RestClient.Builder restClientBuilder, String API_key, String LAT, String LON){
    this.restClient = restClientBuilder.baseURL("https://api.weatherbit.io/v2.0").build();
    this.API_KEY = API_key;
    this.LAT = LAT;
    this.LON = LON;
   }
  

  public currentWeatherDto getCurrentWeather(){
     return restClient.get().uri("/currentlat={LAT}&lon={LON}&key={API_KEY}").retrieve().body(CurrentWeatherDto.class);
   }
}