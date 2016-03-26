package com.mounacheikhna.reactiveapp.ui.trips;

import com.mounacheikhna.reactiveapp.annotation.ScopeSingleton;
import com.mounacheikhna.reactiveapp.data.TripsSource;
import com.mounacheikhna.reactiveapp.data.model.Trip;
import com.mounacheikhna.reactiveapp.ui.base.BasePresenter;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by cheikhnamouna on 3/26/16.
 */
@ScopeSingleton(TripsView.TripsComponent.class)
public class TripsPresenter extends BasePresenter<TripsScreen> {

  @Inject
  public TripsPresenter() {
  }

  public Observable<List<Trip>> getTrips() {
    return Observable.just(TripsSource.getTrips());
  }
}
