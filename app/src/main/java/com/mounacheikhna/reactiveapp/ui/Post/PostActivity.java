package com.mounacheikhna.reactiveapp.ui.Post;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.Bind;
import butterknife.ButterKnife;

import com.mounacheikhna.reactiveapp.BaseActivity;
import com.mounacheikhna.reactiveapp.R;

/**
 * Created by cheikhnamouna on 3/28/16.
 */
public class PostActivity extends BaseActivity {

  @Bind(R.id.post_view) PostView postView;

  @Override
  protected int getLayoutId() {
    return R.layout.post_activity;
  }

}

