package com.mounacheikhna.reactiveapp;

import com.mounacheikhna.reactiveapp.api.ApiModule;
import com.mounacheikhna.reactiveapp.base.AppDep;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by cheikhnamouna on 3/14/16.
 */
@Singleton @Component(modules = {
    AppModule.class, ApiModule.class
})
public interface AppComponent extends AppDep {
  void injectApplication(ReactiveApp app);

  final class Initializer {
    private Initializer() {
    }

    static AppComponent init(ReactiveApp app) {
      return DaggerAppComponent.builder().appModule(new AppModule(app)).build();
    }
  }

}
