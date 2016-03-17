package com.mounacheikhna.reactiveapp.api.geonames;

import com.mounacheikhna.reactiveapp.api.geonames.model.Geonames;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cheikhnamouna on 3/15/16.
 */
public interface GeonamesApi {

  @GET("/search") Observable<Geonames> search(@Query("q") String geoname);

}

