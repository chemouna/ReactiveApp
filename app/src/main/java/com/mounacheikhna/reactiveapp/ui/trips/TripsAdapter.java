package com.mounacheikhna.reactiveapp.ui.trips;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mounacheikhna.reactiveapp.R;
import com.mounacheikhna.reactiveapp.data.model.Trip;
import java.util.List;
import rx.functions.Action1;

/**
 * Created by cheikhnamouna on 3/26/16.
 */
public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.TripViewHolder>
    implements Action1<List<Trip>> {

  private final LayoutInflater inflater;
  private List<Trip> trips;

  public TripsAdapter(Context context) {
    inflater = LayoutInflater.from(context);
  }

  @Override public TripViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = inflater.inflate(R.layout.trip_item, parent, false);
    return new TripViewHolder(v);
  }

  @Override public void onBindViewHolder(TripViewHolder holder, int position) {
    holder.departureCity.setText(trips.get(position).departureCity);
    holder.departureDate.setText(trips.get(position).departureDate);
    holder.arrivalCity.setText(trips.get(position).arrivalCity);
    holder.arrivalDate.setText(trips.get(position).arrivalDate);
  }

  @Override public int getItemCount() {
    return trips.size();
  }

  @Override public void call(List<Trip> trips) {
    this.trips = trips;
  }

  class TripViewHolder extends RecyclerView.ViewHolder {

    public TextView departureCity;
    public TextView departureDate;
    public TextView arrivalCity;
    public TextView arrivalDate;

    public TripViewHolder(View itemView) {
      super(itemView);
    }
  }
}
