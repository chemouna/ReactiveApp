package com.mounacheikhna.reactiveapp.ui.trips;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.mounacheikhna.reactiveapp.R;
import com.mounacheikhna.reactiveapp.data.model.Trip;

/**
 * Created by cheikhnamouna on 3/26/16.
 */
public class TripItemView extends LinearLayout {

  @Bind(R.id.trip_from_to) TextView fromToTv;
  @Bind(R.id.trip_dates) TextView datesTv;

  public TripItemView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public void bind(Trip trip) {
    fromToTv.setText(trip.departureCity + " ->"+ trip.arrivalCity);
    datesTv.setText(trip.departureDate + " -> "+ trip.arrivalDate);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }

}
