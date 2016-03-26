package com.mounacheikhna.reactiveapp.data;

import com.mounacheikhna.reactiveapp.data.model.Profile;

/**
 * Created by cheikhnamouna on 3/27/16.
 */
public class ProfileSource {

  public static Profile getProfile(String id) {
    return new Profile();
  }
}
