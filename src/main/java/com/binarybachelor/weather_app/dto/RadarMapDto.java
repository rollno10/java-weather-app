package com.binarybachelor.weather_app.dto;
import java.util.Map;

public class  RadarMapDto{

  private String host;
  private Map<String, Object> radar;
  private Map<String, Object> satellite;

  public String getHost(){
    return host;
  }
  public void setHost(String host){
    this.host = host;
  }
  public Map<String, Object> getRadar(){
    return radar;
  }
  public void setRadar(Map<String, Object> radar){
    this.radar = radar;
  }
  public Map<String, Object> getSatellite(){
    return satellite;
  }
  public void setSatellite(Map<String, Object> satellite){
    this.satellite = satellite;
  }
}