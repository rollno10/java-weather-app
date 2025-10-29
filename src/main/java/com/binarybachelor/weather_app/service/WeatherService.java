package com.binarybachelor.weather_app.service;
import com.binarybachelor.weather_app.dto.CurrentWeatherDto;
import com.binarybachelor.weather_app.dto.ForcastWeatherDto;
import com.binarybachelor.weather_app.dto.GeoCodeDto;
import com.binarybachelor.weather_app.dto.WeatherResponseDto;
import java.util.List;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import com.binarybachelor.weather_app.dto.RadarMapDto;


@Service
public class  WeatherService {

  private final RestClient weatherRestClient;
  private final RestClient geoCodeRestClient;
  private final RestClient radarMapRestClient;
  
  public WeatherService(RestClient.Builder restClientBuilder){
    
    this.weatherRestClient = restClientBuilder.baseUrl("https://api.weatherbit.io/v2.0").build();
    
    this.geoCodeRestClient = restClientBuilder.baseUrl("https://geocode.maps.co").build();

    this.radarMapRestClient = restClientBuilder.baseUrl("https://api.rainviewer.com/public/weather-maps.json").build();
   }
  
  public GeoCodeDto getGeoCode(String CITY){
    String city = CITY;
    ParameterizedTypeReference<List<GeoCodeDto>> typeRef = new ParameterizedTypeReference<>() {};
    List<GeoCodeDto> response =  geoCodeRestClient
      .get()
      .uri("/search?q={CITY}",city)
      .retrieve()
      .body(typeRef);
    return response.get(0);
  }

  public RadarMapDto getRadarMap(){
    return radarMapRestClient
      .get()
      .retrieve()
      .body(RadarMapDto.class);
  }
  

  public CurrentWeatherDto getCurrentWeather(String API_KEY, String LAT, String LON){
    Map<String, String> params = Map.of("LAT", LAT, "LON", LON, "API_KEY", API_KEY);
    
    ParameterizedTypeReference<WeatherResponseDto<CurrentWeatherDto>> responseType = new ParameterizedTypeReference<WeatherResponseDto<CurrentWeatherDto>>() {};
    
    WeatherResponseDto<CurrentWeatherDto> response = weatherRestClient
      .get()
      .uri("/current?lat={LAT}&lon={LON}&key={API_KEY}",params)
      .retrieve()
      .body(responseType);

    return response.getData().get(0);
   }

   public List<ForcastWeatherDto> getForecastWeather(String API_KEY, String LAT, String LON){
     Map<String, String> params = Map.of("LAT", LAT, "LON", LON, "API_KEY", API_KEY);

     ParameterizedTypeReference<WeatherResponseDto<ForcastWeatherDto>> responseType = new ParameterizedTypeReference<WeatherResponseDto<ForcastWeatherDto>>() {};

   WeatherResponseDto<ForcastWeatherDto> response = weatherRestClient
     .get()
     .uri("/forecast/daily?lat={LAT}&lon={LON}&key={API_KEY}",params)
     .retrieve()
     .body(responseType);

   return response.getData();
  }
}