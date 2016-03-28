package com.mounacheikhna.reactiveapp.ui.search;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

import com.mounacheikhna.reactiveapp.BaseActivity;
import com.mounacheikhna.reactiveapp.R;
import com.mounacheikhna.reactiveapp.ui.trips.TripsView;

/**
 * Created by cheikhnamouna on 3/28/16.
 */
public class SearchActivity extends BaseActivity {

  @Override
  protected int getLayoutId() {
    return R.layout.search_activity;
  }

}
