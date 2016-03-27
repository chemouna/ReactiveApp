package com.mounacheikhna.reactiveapp.ui.search;

import com.mounacheikhna.reactiveapp.annotation.ScopeSingleton;
import com.mounacheikhna.reactiveapp.api.geonames.GeonamesApi;
import com.mounacheikhna.reactiveapp.api.geonames.model.Geoname;
import com.mounacheikhna.reactiveapp.data.TripsSource;
import com.mounacheikhna.reactiveapp.data.model.Trip;
import com.mounacheikhna.reactiveapp.ui.base.BasePresenter;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by cheikhnamouna on 3/14/16.
 */
@ScopeSingleton(SearchView.SearchComponent.class)
public class SearchPresenter extends BasePresenter<SearchScreen> {

  private GeonamesApi api;

  @Inject
  public SearchPresenter(GeonamesApi api) {
    this.api = api;
  }

  public Observable<List<Geoname>> searchPlace(String query) {
    return api.search(query);
  }

  public Observable<List<Trip>> searchRides(String departure, String arrival) {
    return Observable.just(TripsSource.getTrips());
  }
}

