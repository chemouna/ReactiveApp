package com.mounacheikhna.reactiveapp.base;

import android.app.Application;
import android.content.Context;
import com.mounacheikhna.reactiveapp.annotation.ApplicationContext;

/**
 * Created by cheikhnamouna on 3/17/16.
 */
public interface AppDep {
  Application application();

  @ApplicationContext Context provideApplicationContext();

  GeonamesApi provideGeonamesApi();
}
