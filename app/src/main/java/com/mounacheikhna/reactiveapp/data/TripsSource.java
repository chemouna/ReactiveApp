package com.mounacheikhna.reactiveapp.data;

import com.mounacheikhna.reactiveapp.data.model.Trip;

/**
 * Created by cheikhnamouna on 3/26/16.
 */
public class TripsSource {

  public Trip[] getTrips() {
    return new Trip[] {
      new Trip("Leyla", "Rabat", "20/05/2016", "Mohamedia", "21/05/2016")
    };
  }
}
