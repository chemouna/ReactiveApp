package com.mounacheikhna.reactiveapp.ui.search;

import com.mounacheikhna.reactiveapp.annotation.ScopeSingleton;
import com.mounacheikhna.reactiveapp.api.geonames.GeonamesApi;
import com.mounacheikhna.reactiveapp.api.geonames.model.Geoname;
import com.mounacheikhna.reactiveapp.api.geonames.model.Geonames;
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
}

