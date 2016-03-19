package com.mounacheikhna.reactiveapp;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

/**
 * Created by cheikhnamouna on 3/14/16.
 */
public class ReactiveApp extends Application {

  private AppComponent component;

  @Override public void onCreate() {
    super.onCreate();
    component = AppComponent.Initializer.init(this);
    component.injectApplication(this);
    Stetho.initializeWithDefaults(this);
  }

  public static ReactiveApp get(Context context) {
    return (ReactiveApp) context.getApplicationContext();
  }

  public AppComponent getComponent() {
    return component;
  }


}
