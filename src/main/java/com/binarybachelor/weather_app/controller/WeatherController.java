package com.binarybachelor.weather_app.controller;

import com.binarybachelor.weather_app.service.CurrentWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.binarybachelor.weather_app.dto.CurrentWeatherDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    
    @Autowired    
    private final CurrentWeatherService currentWeatherService;

    @GetMapping("/current")
    public ResponseEntity<CurrentWeatherDto> getCurrentWeather(@RequestBody Map<String,String> body){
        String lat = body.get("lat");
        String lon = body.get("lon");
        String api_key = body.get("api_key");
        return ResponseEntity.ok(currentWeatherService.getCurrentWeather());
    }
}