package com.mounacheikhna.reactiveapp.api.geonames;

import com.mounacheikhna.reactiveapp.api.geonames.model.Geoname;
import com.mounacheikhna.reactiveapp.api.geonames.model.Geonames;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cheikhnamouna on 3/15/16.
 */
public interface GeonamesApi {

  @GET("/search") Observable<List<Geoname>> search(@Query("q") String input);

}

