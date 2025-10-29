package com.binarybachelor.weather_app.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class  CurrentWeatherResponseDto{

    private List<CurrentWeatherDto> data;

    public void setData(List<CurrentWeatherDto> data){
        this.data = data;
    }
    public List<CurrentWeatherDto> getData(){
        return data;
    }
}