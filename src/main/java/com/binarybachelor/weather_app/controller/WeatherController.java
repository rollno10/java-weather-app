package com.binarybachelor.weather_app.controller;

import com.binarybachelor.weather_app.dto.CurrentWeatherDto;
import com.binarybachelor.weather_app.service.WeatherService;
import java.util.Map;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.binarybachelor.weather_app.dto.WeatherResponseDto;
import com.binarybachelor.weather_app.dto.ForcastWeatherDto;
import com.binarybachelor.weather_app.dto.GeoCodeDto;
import com.binarybachelor.weather_app.dto.RadarMapDto;
import com.binarybachelor.weather_app.dto.HourlyWeatherDto;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {
    
    @Autowired    
    private WeatherService WeatherService;

    @GetMapping("/geocode")
    public ResponseEntity<GeoCodeDto> getGeoCode(@RequestBody Map<String,String> body){
        return ResponseEntity.ok(WeatherService.getGeoCode(body.get("city")));
    }

    @GetMapping("/current")
    public ResponseEntity<CurrentWeatherDto> getCurrentWeather(@RequestBody Map<String,String> body){
        
        GeoCodeDto geoCode = WeatherService.getGeoCode(body.get("city"));

        return ResponseEntity.ok(WeatherService.getCurrentWeather(body.get("api_key"),geoCode.getLat(),geoCode.getLon(),body.get("city")));
    }

    @GetMapping("/forecast")
    public ResponseEntity<List<ForcastWeatherDto>> getForecastWeather(@RequestBody Map<String,String> body){

        GeoCodeDto geoCode = WeatherService.getGeoCode(body.get("city"));

        return ResponseEntity.ok(WeatherService.getForecastWeather(body.get("api_key"),geoCode.getLat(),geoCode.getLon(),body.get("city")));
    }

    @GetMapping("/radar")
    public ResponseEntity<RadarMapDto> getRadarMap(){
        return ResponseEntity.ok(WeatherService.getRadarMap());
    }

    @GetMapping("/hourly")
    public ResponseEntity<List<HourlyWeatherDto>> getHourlyWeather(@RequestBody Map<String,String> body){
        return ResponseEntity.ok(WeatherService.getHourlyWeather(body.get("api_key"),body.get("city")));
    }
}