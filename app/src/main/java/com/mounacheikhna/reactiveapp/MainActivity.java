package com.mounacheikhna.reactiveapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.mounacheikhna.reactiveapp.ui.Post.PostActivity;
import com.mounacheikhna.reactiveapp.ui.trips.TripsView;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.trips_view) TripsView tripsView;
    @Bind(R.id.content) RelativeLayout contentContainer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tripsView.displayDefault();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.post)
    public void post() {
        startActivity(new Intent(this, PostActivity.class));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
