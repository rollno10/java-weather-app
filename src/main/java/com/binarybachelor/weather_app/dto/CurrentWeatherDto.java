package com.binarybachelor.weather_app.dto;

public class CurrentWeatherDto{
  
    private final String weather_desc;
    private final String weather_icon;
    private final String time_stamp;
    private final String degree_celsius;
    private final  String real_feel;
    private final String wind;
    private final String wind_gusts;

    public CurrentWeatherDto(String weather_desc, String weather_icon, String time_stamp, String degree_celsius, String real_feel, String wind, String wind_gusts){
        this.weather_desc = weather_desc;
        this.weather_icon = weather_icon;
        this.time_stamp = time_stamp;
        this.degree_celsius = degree_celsius;
        this.real_feel = real_feel;
        this.wind = wind;
        this.wind_gusts = wind_gusts;
    }
    public String getWeather_desc() {
        return weather_desc;
    }
    public String getWeather_icon() {
        return weather_icon;
    }
    public String getTime_stamp() {
        return time_stamp;
    }  
    public String getDegree_celsius() {
        return degree_celsius;
    }
    public String getReal_feel() {
        return real_feel;
    }
    public String getWind() {
        return wind;
    }
    public String getWind_gusts(){
        return wind_gusts;
    }
}