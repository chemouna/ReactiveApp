package com.mounacheikhna.reactiveapp;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;

import rx.plugins.DebugHook;
import rx.plugins.DebugNotification;
import rx.plugins.DebugNotificationListener;
import rx.plugins.RxJavaPlugins;
import timber.log.Timber;

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
    setupRxJavaDebug();
  }

  public static ReactiveApp get(Context context) {
    return (ReactiveApp) context.getApplicationContext();
  }

  public AppComponent getComponent() {
    return component;
  }

  @SuppressWarnings("unchecked") private void setupRxJavaDebug() {
    RxJavaPlugins.getInstance()
            .registerObservableExecutionHook(new DebugHook(new DebugNotificationListener() {
              @Override public Object onNext(DebugNotification n) {
                Timber.v("DebugHook - onNext with value " + n.getValue() + " from op : " + n.getFrom());
                return super.onNext(n);
              }

              @Override public Object start(DebugNotification n) {
                return super.start(n);
              }

              @Override public void complete(Object context) {
                super.complete(context);
              }

              @Override public void error(Object context, Throwable e) {
                super.error(context, e);
                Timber.v("DebugHook - error event e : " + e.getCause());
              }
            }));
  }

}
