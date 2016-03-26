package com.mounacheikhna.reactiveapp.data;

import com.mounacheikhna.reactiveapp.data.model.Trip;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cheikhnamouna on 3/26/16.
 */
public class TripsSource {

  public static List<Trip> getTrips() {
    List<Trip> trips = new ArrayList<>();
    trips.add(new Trip("Leyla", "Rabat", "20/05/2016", "Mohamedia", "21/05/2016"));
    return trips;
  }
}
