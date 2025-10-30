package com.binarybachelor.weather_app.external;
import org.springframework.web.client.RestClient;
import com.binarybachelor.weather_app.dto.RadarMapDto;

public class  RainViewerApi{

  private final RestClient radarMapRestClient;

  public RainViewerApi(RestClient.Builder restClientBuilder){

    this.radarMapRestClient = restClientBuilder.baseUrl("https://api.rainviewer.com/public/weather-maps.json").build();
    
  }

  public RadarMapDto callRainViewerApi(){
    return radarMapRestClient
      .get()
      .retrieve()
      .body(RadarMapDto.class);
  }

}