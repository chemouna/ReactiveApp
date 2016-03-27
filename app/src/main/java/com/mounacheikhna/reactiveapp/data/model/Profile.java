package com.mounacheikhna.reactiveapp.data.model;

import java.util.List;

/**
 * Created by cheikhnamouna on 3/27/16.
 */
public class Profile {

  public String name;
  public int age;
  public String gender; //M/F
  public String city;
  public int rating;
  public List<String> comments;

  public Profile(String name, int age, String gender, String city, int rating,
      List<String> comments) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.city = city;
    this.rating = rating;
    this.comments = comments;
  }


}
