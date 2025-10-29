package com.binarybachelor.weather_app.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeatherDto{
  
    private double temp;
    private double app_temp;
    private double wind_spd;
    private double wind_dir;
    private Weather weather;
    private String ob_time;

    public double getTemp(){
        return temp;
    }
    public void setTemp(double temp){
        this.temp = temp;
    }
    public double getApp_temp(){
        return app_temp;
    }
    public void setApp_temp(double app_temp){
        this.app_temp = app_temp;
    }
    public double getWind_spd(){
        return wind_spd;
    }
    public void setWind_spd(double wind_spd){
        this.wind_spd = wind_spd;
    }
    public double getWind_dir(){
        return wind_dir;
    }
    public void setWind_dir(double wind_dir){
        this.wind_dir = wind_dir;
    }
    public Weather getWeather(){
        return weather;
    }
    public void setWeather(Weather weather){
        this.weather = weather;
    }
    public String getOb_time(){
        return ob_time;
    }
    public void setOb_time(String ob_time){
        this.ob_time = ob_time;
    }

    public static class  Weather{
        private String description;
        private String icon;

        public String getDescription(){
            return description;
        }
        public void setDescription(String description){
            this.description = description;
        }
        public String getIcon(){
            return icon;
        }
        public void setIcon(String icon){
            this.icon = icon;
        }
    }
}