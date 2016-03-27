package com.mounacheikhna.reactiveapp.ui.profil;

import com.mounacheikhna.reactiveapp.annotation.ScopeSingleton;
import com.mounacheikhna.reactiveapp.ui.base.BasePresenter;
import javax.inject.Inject;

/**
 * Created by cheikhnamouna on 3/27/16.
 */
@ScopeSingleton(ProfileView.ProfileComponent.class)
public class ProfilePresenter extends BasePresenter<ProfileScreen> {

  @Inject
  public ProfilePresenter() {
  }


}
