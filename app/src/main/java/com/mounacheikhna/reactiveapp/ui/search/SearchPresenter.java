package com.mounacheikhna.reactiveapp.ui.search;

import com.mounacheikhna.trips.api.geonames.GeonamesApi;
import com.mounacheikhna.trips.api.geonames.model.Geonames;
import com.mounacheikhna.trips.ui.base.BasePresenter;
import rx.Observable;

/**
 * Created by cheikhnamouna on 3/14/16.
 */
public class SearchPresenter extends BasePresenter<SearchScreen> {

  private GeonamesApi api;

  public SearchPresenter(GeonamesApi api) {
    this.api = api;
  }

  public Observable<Geonames> SearchPlace(String query) {
    return api.search(query);
  }
}
