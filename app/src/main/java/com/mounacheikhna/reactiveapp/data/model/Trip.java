package com.mounacheikhna.reactiveapp.data.model;

/**
 * Created by cheikhnamouna on 3/26/16.
 */
public class Trip {

  public String username;
  public String image;
  public String departureCity;
  public String departureDate;
  public String arrivalCity;
  public String arrivalDate;
  public String price;

  public Trip(String username, String departureCity, String departureDate, String arrivalCity,
      String arrivalDate, String price) {
    this.username = username;
    this.departureCity = departureCity;
    this.departureDate = departureDate;
    this.arrivalCity = arrivalCity;
    this.arrivalDate = arrivalDate;
    this.price = price;
  }

}
