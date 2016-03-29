package com.mounacheikhna.reactiveapp.ui.trips;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.mounacheikhna.reactiveapp.R;
import com.mounacheikhna.reactiveapp.data.model.Trip;
import com.squareup.picasso.Picasso;

/**
 * Created by cheikhnamouna on 3/26/16.
 */
public class TripItemView extends LinearLayout {

  @Bind(R.id.trip_from_to) TextView fromToTv;
  @Bind(R.id.trip_dates) TextView datesTv;
  @Bind(R.id.user_image) ImageView userImage;
  @Bind(R.id.price) TextView priceTv;

  public TripItemView(Context context) {
    super(context);
  }

  public TripItemView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public void bind(Trip trip, Picasso picasso) {
    fromToTv.setText(trip.departureCity + " -> "+ trip.arrivalCity);
    datesTv.setText(trip.departureDate + " -> "+ trip.arrivalDate);
    priceTv.setText(trip.price);
    picasso.load(trip.image).into(userImage);
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }

}
