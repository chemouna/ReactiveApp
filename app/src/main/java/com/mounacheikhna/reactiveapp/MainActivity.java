package com.mounacheikhna.reactiveapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mounacheikhna.reactiveapp.ui.Post.PostActivity;
import com.mounacheikhna.reactiveapp.ui.trips.TripsView;

public class MainActivity extends AppCompatActivity {

  @Bind(R.id.trips_view) TripsView tripsView;
  @Bind(R.id.content) RelativeLayout contentContainer;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    AccountHeader headerResult = new AccountHeaderBuilder()
        .withActivity(this)
        .withHeaderBackground(R.drawable.header)
        .addProfiles(
            new ProfileDrawerItem().withName("Leila").withEmail("example@gmail.com")
                .withIcon(ContextCompat.getDrawable(this, R.drawable.women))
        )
        .withOnAccountHeaderListener((view, profile, currentProfile) -> false)
        .build();

    new DrawerBuilder()
        .withActivity(this)
        .withToolbar(toolbar)
        .withAccountHeader(headerResult)
        .addDrawerItems(
            new PrimaryDrawerItem().withName(R.string.search),
            new DividerDrawerItem(),
            new PrimaryDrawerItem().withName(R.string.post)
        )
        .build();

    //TODO: display only when on main screen
    tripsView.displayDefault();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
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

}
