package com.mounacheikhna.reactiveapp.ui.profile;

import com.mounacheikhna.reactiveapp.annotation.ScopeSingleton;
import com.mounacheikhna.reactiveapp.base.BaseComponent;

/**
 * Created by cheikhnamouna on 3/27/16.
 */
public class ProfileView implements ProfileScreen {


  @ScopeSingleton(ProfileComponent.class)
  public interface ProfileComponent extends BaseComponent {
    void inject(ProfileView profileView);
  }

}
