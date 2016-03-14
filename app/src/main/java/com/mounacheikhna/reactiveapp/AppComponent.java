package com.mounacheikhna.reactiveapp;

import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by cheikhnamouna on 3/14/16.
 */
@Singleton @Component(modules = {
    AppModule.class
})
public interface AppComponent {
  void injectApplication(ReactiveApp app);

  final class Initializer {
    private Initializer() {
    }

    static AppComponent init(ReactiveApp app) {
      return DaggerAppComponent.builder().appModule(new AppModule(app)).build();
    }
  }

}
