package com.mounacheikhna.reactiveapp.data;

import com.mounacheikhna.reactiveapp.data.model.Profile;
import java.util.ArrayList;

/**
 * Created by cheikhnamouna on 3/27/16.
 */
public class ProfileSource {

  public static Profile getProfile(String id) {
    return new Profile("Ali", 25, "M", "Nouakchott", 4, new ArrayList<>());
  }
}
