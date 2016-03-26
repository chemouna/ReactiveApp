package com.mounacheikhna.reactiveapp.ui.trips;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mounacheikhna.reactiveapp.R;
import com.mounacheikhna.reactiveapp.data.model.Trip;
import java.util.List;
import rx.functions.Action1;

/**
 * Created by cheikhnamouna on 3/26/16.
 */
public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder>
    implements Action1<List<Trip>> {

  private final LayoutInflater inflater;
  private List<Trip> trips;

  public TripAdapter(Context context) {
    inflater = LayoutInflater.from(context);
  }

  @Override public TripViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = inflater.inflate(R.layout.trip_item, parent, false);
    return new TripViewHolder((TripItemView) v);
  }

  @Override public void onBindViewHolder(TripViewHolder holder, int position) {
    holder.itemView.bind(trips.get(position));
  }

  @Override public int getItemCount() {
    return trips.size();
  }

  @Override public void call(List<Trip> trips) {
    this.trips = trips;
  }

  class TripViewHolder extends RecyclerView.ViewHolder {
    public final TripItemView itemView;

    public TripViewHolder(TripItemView itemView) {
      super(itemView);
      this.itemView = itemView;
    }

  }
}
