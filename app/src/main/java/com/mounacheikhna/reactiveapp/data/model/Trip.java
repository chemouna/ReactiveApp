package com.mounacheikhna.reactiveapp.data.model;

/**
 * Created by cheikhnamouna on 3/26/16.
 */
public class Trip {

  String username;
  String departureCity;
  String departureDate;
  String arrivalCity;
  String arrivalDate;

  public Trip(String username, String departureCity, String departureDate, String arrivalCity,
      String arrivalDate) {
    this.username = username;
    this.departureCity = departureCity;
    this.departureDate = departureDate;
    this.arrivalCity = arrivalCity;
    this.arrivalDate = arrivalDate;
  }
}
