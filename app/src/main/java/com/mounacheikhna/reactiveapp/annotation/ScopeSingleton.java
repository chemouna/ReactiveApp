package com.mounacheikhna.reactiveapp.annotation;

import javax.inject.Scope;

@Scope
public @interface ScopeSingleton {
  Class<?> value();
}
