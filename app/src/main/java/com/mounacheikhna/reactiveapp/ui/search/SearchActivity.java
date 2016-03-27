package com.mounacheikhna.reactiveapp.ui.search;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.mounacheikhna.reactiveapp.ui.trips.TripsView;

/**
 * Created by cheikhnamouna on 3/28/16.
 */
public class SearchActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.search_activity);
    ButterKnife.bind(this);
  }
}
