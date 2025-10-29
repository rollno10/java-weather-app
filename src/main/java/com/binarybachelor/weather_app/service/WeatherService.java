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
import com.binarybachelor.weather_app.dto.HourlyWeatherDto;
import com.binarybachelor.weather_app.dto.HourlyWeatherResponseDto;
import com.binarybachelor.weather_app.dto.ForecastDayDto;
import com.binarybachelor.weather_app.dto.ForecastDto;


@Service
public class  WeatherService {

  private final RestClient weatherRestClient;
  private final RestClient geoCodeRestClient;
  private final RestClient radarMapRestClient;
  private final RestClient hourlyWeatherRestClient;
  
  public WeatherService(RestClient.Builder restClientBuilder){
    
    this.weatherRestClient = restClientBuilder.baseUrl("https://api.weatherbit.io/v2.0").build();
    
    this.geoCodeRestClient = restClientBuilder.baseUrl("https://geocode.maps.co").build();

    this.radarMapRestClient = restClientBuilder.baseUrl("https://api.rainviewer.com/public/weather-maps.json").build();

    this.hourlyWeatherRestClient = restClientBuilder.baseUrl("https://api.weatherapi.com/v1").build();
    
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

  public List<HourlyWeatherDto> getHourlyWeather(String API_KEY, String CITY){

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