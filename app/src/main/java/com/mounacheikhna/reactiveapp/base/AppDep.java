package com.mounacheikhna.reactiveapp.base;

import android.app.Application;
import android.content.Context;
import com.mounacheikhna.reactiveapp.annotation.ApplicationContext;
import com.mounacheikhna.reactiveapp.api.geonames.GeonamesApi;
import com.squareup.picasso.Picasso;

/**
 * Created by cheikhnamouna on 3/17/16.
 */
public interface AppDep {
  Application application();

  @ApplicationContext Context provideApplicationContext();

  GeonamesApi provideGeonamesApi();

  Picasso providePicasso();

}
