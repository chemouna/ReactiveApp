package com.mounacheikhna.reactiveapp.ui.trips;

import android.content.Context;
import com.mounacheikhna.reactiveapp.annotation.ScopeSingleton;
import com.mounacheikhna.reactiveapp.data.TripsSource;
import com.mounacheikhna.reactiveapp.data.model.Trip;
import com.mounacheikhna.reactiveapp.ui.base.BasePresenter;
import github.cesarferreira.rxpeople.RxPeople;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;

/**
 * Created by cheikhnamouna on 3/26/16.
 */
@ScopeSingleton(TripsView.TripsComponent.class) public class TripsPresenter
    extends BasePresenter<TripsScreen> {

  @Inject public TripsPresenter() {
  }

  public Observable<List<Trip>> getTrips(Context context) {
     return RxPeople.with(context)
        .amount(5)
        .intoObservable()
        .flatMap(fakeUsers -> {
          List<Trip> trips = TripsSource.getTrips();
          for (int i = 0; i < trips.size(); i++) {
            trips.get(i).image = fakeUsers.get(i).getPicture().medium;
          }
          return Observable.just(trips);
        });
  }
}
