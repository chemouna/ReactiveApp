package com.mounacheikhna.reactiveapp.api.geonames.model;

/**
 * Created by cheikhnamouna on 3/15/16.
 */
public class Geoname {

  String toponymName;
  String name;
  String lat;
  String lng;
  String geonameId;
  String countryCode;
  String countryName;
  String fcl;
  String fcode;

  public Geoname(String toponymName, String name, String lat, String lng, String geonameId,
      String countryCode, String countryName, String fcl, String fcode) {
    this.toponymName = toponymName;
    this.name = name;
    this.lat = lat;
    this.lng = lng;
    this.geonameId = geonameId;
    this.countryCode = countryCode;
    this.countryName = countryName;
    this.fcl = fcl;
    this.fcode = fcode;
  }
}
