package com.mounacheikhna.reactiveapp.ui.trips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.mounacheikhna.reactiveapp.AppComponent;
import com.mounacheikhna.reactiveapp.R;
import com.mounacheikhna.reactiveapp.ReactiveApp;
import com.mounacheikhna.reactiveapp.annotation.ScopeSingleton;
import com.mounacheikhna.reactiveapp.base.BaseComponent;
import com.mounacheikhna.reactiveapp.ui.search.DaggerSearchView_SearchComponent;
import com.mounacheikhna.reactiveapp.ui.search.SearchScreen;
import dagger.Component;
import javax.inject.Inject;

/**
 * Created by cheikhnamouna on 3/26/16.
 */
public class TripsView extends LinearLayout implements TripsScreen {

  @Inject TripsPresenter tripsPresenter;

  public TripsView(Context context) {
    super(context);
    init(context);
  }

  private void init(Context context) {
    final View view = LayoutInflater.from(context).inflate(R.layout.search, this, true);
    ButterKnife.bind(this, view);
    DaggerTripsView_TripsComponent.builder()
        .appComponent(ReactiveApp.get(getContext()).getComponent())
        .build()
        .inject(this);
  }

  @ScopeSingleton(TripsComponent.class)
  @Component(dependencies = AppComponent.class)
  public interface TripsComponent extends BaseComponent {
    void inject(TripsView tripsView);
  }

}
