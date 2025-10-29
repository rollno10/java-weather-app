package com.binarybachelor.weather_app.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponseDto<T>{

    private List<T> data;

    public void setData(List<T> data){
        this.data = data;
    }
    public List<T> getData(){
        return data;
    }
}