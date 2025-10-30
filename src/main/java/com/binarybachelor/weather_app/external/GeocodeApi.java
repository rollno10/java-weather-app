package com.binarybachelor.weather_app.external;
import org.springframework.web.client.RestClient;
import org.springframework.core.ParameterizedTypeReference;
import com.binarybachelor.weather_app.dto.GeoCodeDto;
import java.util.List;

public class  GeocodeApi{

  private final RestClient geoCodeRestClient;

  public GeocodeApi(RestClient.Builder restClientBuilder){

    this.geoCodeRestClient = restClientBuilder.baseUrl("https://geocode.maps.co").build();
    
  }

  public GeoCodeDto callGeoCodeApi(String CITY){
    String city = CITY;
    ParameterizedTypeReference<List<GeoCodeDto>> typeRef = new ParameterizedTypeReference<>() {};
    List<GeoCodeDto> response =  geoCodeRestClient
      .get()
      .uri("/search?q={CITY}",city)
      .retrieve()
      .body(typeRef);
    return response.get(0);
  }
  
}