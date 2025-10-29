package com.binarybachelor.weather_app.dto;

public class  ForcastWeatherDto{
  
    private String datetime;
    private double temp;
    private double high_temp;
    private double low_temp;
    private Weather weather;
    private int pop;

    public String getDatetime(){
        return datetime;
    }
    public void setDatetime(String datetime){
        this.datetime = datetime;
    }
    public double getTemp(){
        return temp;
    }
    public void setTemp(double temp){
        this.temp = temp;
    }
    public double getHigh_temp(){
        return high_temp;
    }
    public void setHigh_temp(double high_temp){
        this.high_temp = high_temp;
    }
    public double getLow_temp(){
        return low_temp;
    }
    public void setLow_temp(double low_temp){
        this.low_temp = low_temp;
    }
    public Weather getWeather(){
        return weather;
    }
    public void setWeather(Weather weather){
        this.weather = weather;
    }
    public int getPop(){
        return pop;
    }
    public void setPop(int pop){
        this.pop = pop;
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