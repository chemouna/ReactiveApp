package com.mounacheikhna.reactiveapp;

import android.app.Application;
import android.content.Context;

/**
 * Created by cheikhnamouna on 3/14/16.
 */
public class ReactiveApp extends Application {

  private AppComponent mComponent;

  @Override public void onCreate() {
    super.onCreate();
    mComponent = AppComponent.Initializer.init(this);
    mComponent.injectApplication(this);
  }

  public static ReactiveApp get(Context context) {
    return (ReactiveApp) context.getApplicationContext();
  }

  public AppComponent getComponent() {
    return mComponent;
  }


}
