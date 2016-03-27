package com.mounacheikhna.reactiveapp.ui.trips;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Bind;
import butterknife.BindDimen;
import butterknife.ButterKnife;
import com.mounacheikhna.reactiveapp.AppComponent;
import com.mounacheikhna.reactiveapp.R;
import com.mounacheikhna.reactiveapp.ReactiveApp;
import com.mounacheikhna.reactiveapp.annotation.ScopeSingleton;
import com.mounacheikhna.reactiveapp.base.BaseComponent;
import com.mounacheikhna.reactiveapp.data.model.Trip;
import com.mounacheikhna.reactiveapp.ui.recyclerview.OffsetDecoration;
import com.squareup.picasso.Picasso;
import dagger.Component;
import java.util.List;
import javax.inject.Inject;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by cheikhnamouna on 3/26/16.
 */
public class TripsView extends LinearLayout implements TripsScreen {

  @Inject TripsPresenter tripsPresenter;
  @Inject Picasso picasso;

  @Bind(R.id.rv_trips) RecyclerView tripsRv;
  @BindDimen(R.dimen.spacing_normal) int spacingNormal;
  private TripAdapter adapter;

  public TripsView(Context context) {
    super(context);
    init(context);
  }

  public TripsView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  public TripsView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init(context);
  }

  @TargetApi(Build.VERSION_CODES.LOLLIPOP)
  public TripsView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    super(context, attrs, defStyleAttr, defStyleRes);
    init(context);
  }

  private void init(Context context) {
    if (isInEditMode()) return;
    final View view = LayoutInflater.from(context).inflate(R.layout.trips, this, true);
    ButterKnife.bind(this, view);
    DaggerTripsView_TripsComponent.builder()
        .appComponent(ReactiveApp.get(getContext()).getComponent())
        .build()
        .inject(this);

    tripsRv.setLayoutManager(new LinearLayoutManager(context));
    tripsRv.setClipToPadding(false);
    tripsRv.addItemDecoration(new OffsetDecoration(spacingNormal));
    adapter = new TripAdapter(picasso);
    tripsRv.setAdapter(adapter);
  }

  public void displayDefault() {
    tripsPresenter.getTrips(getContext()).subscribe(adapter);
  }

  public void display(Observable<List<Trip>> tripsObservable) {
    tripsObservable
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(adapter);
  }

  @ScopeSingleton(TripsComponent.class)
  @Component(dependencies = AppComponent.class)
  public interface TripsComponent extends BaseComponent {
    void inject(TripsView tripsView);
  }

}
