package com.binarybachelor.weather_app.external;
import org.springframework.web.client.RestClient;
import org.springframework.core.ParameterizedTypeReference;
import com.binarybachelor.weather_app.dto.WeatherResponseDto;
import com.binarybachelor.weather_app.dto.CurrentWeatherDto;
import java.util.Map;
import java.util.List;
import com.binarybachelor.weather_app.dto.ForcastWeatherDto;

public class WeatherBitApi{

  private final RestClient weatherbitRestClient;

  public WeatherBitApi(RestClient.Builder restClientBuilder){

    this.weatherbitRestClient = restClientBuilder.baseUrl("https://api.weatherbit.io/v2.0").build();
    
  }

  public CurrentWeatherDto callCurrentWeatherBitApi(String API_KEY, String LAT, String LON){
    Map<String, String> params = Map.of("LAT", LAT, "LON", LON, "API_KEY", API_KEY);

    ParameterizedTypeReference<WeatherResponseDto<CurrentWeatherDto>> responseType = new ParameterizedTypeReference<WeatherResponseDto<CurrentWeatherDto>>() {};

    WeatherResponseDto<CurrentWeatherDto> response = weatherbitRestClient
      .get()
      .uri("/current?lat={LAT}&lon={LON}&key={API_KEY}",params)
      .retrieve()
      .body(responseType);

    return response.getData().get(0);
   }

  public List<ForcastWeatherDto> callForecastWeatherApi(String API_KEY, String LAT, String LON){
     Map<String, String> params = Map.of("LAT", LAT, "LON", LON, "API_KEY", API_KEY);

     ParameterizedTypeReference<WeatherResponseDto<ForcastWeatherDto>> responseType = new ParameterizedTypeReference<WeatherResponseDto<ForcastWeatherDto>>() {};

   WeatherResponseDto<ForcastWeatherDto> response = weatherbitRestClient
     .get()
     .uri("/forecast/daily?lat={LAT}&lon={LON}&key={API_KEY}",params)
     .retrieve()
     .body(responseType);

   return response.getData();
  }
  
}