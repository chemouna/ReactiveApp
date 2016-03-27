package com.mounacheikhna.reactiveapp.ui.Post;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.mounacheikhna.reactiveapp.R;

/**
 * Created by cheikhnamouna on 3/28/16.
 */
public class PostActivity extends AppCompatActivity {

  @Bind(R.id.post_view) PostView postView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.post_activity);
    ButterKnife.bind(this);
  }

}

