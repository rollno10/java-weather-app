package com.binarybachelor.weather_app.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class  HourlyWeatherDto{

  private String time;
  private double temp_c;
  private Condition condition;

  public String getTime(){
    return time;
  }
  public void setTime(String time){
    this.time = time;
  }
  public double getTemp_c(){
    return temp_c;
  }
  public void setTemp_c(double temp_c){
    this.temp_c = temp_c;
  }
  public Condition getCondition(){
    return condition;
  }
  public void setCondition(Condition condition){
    this.condition = condition;
  }

  public static class Condition{

    private String text;
    private String icon;

    public String getText(){
      return text;
    }
    public void setText(String text){
      this.text = text;
    }
    public String getIcon(){
      return icon;
    }
    public void setIcon(String icon){
      this.icon = "https:"+icon;
    }
  }
}