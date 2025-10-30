package com.binarybachelor.weather_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

import com.binarybachelor.weather_app.external.GeocodeApi;
import com.binarybachelor.weather_app.external.WeatherBitApi;
import com.binarybachelor.weather_app.external.RainViewerApi;
import com.binarybachelor.weather_app.external.WeatherApi;

@Configuration
public class ExternalApiConfig {

    @Bean
    public GeocodeApi geocodeApi(RestClient.Builder builder) {
        return new GeocodeApi(builder);
    }

    @Bean
    public WeatherBitApi weatherBitApi(RestClient.Builder builder) {
        return new WeatherBitApi(builder);
    }

    @Bean
    public RainViewerApi rainViewerApi(RestClient.Builder builder) {
        return new RainViewerApi(builder);
    }

    @Bean
    public WeatherApi weatherApi(RestClient.Builder builder){
        return new WeatherApi(builder);
    }
}
