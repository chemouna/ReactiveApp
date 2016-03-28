package com.mounacheikhna.reactiveapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mounacheikhna.reactiveapp.ui.Post.PostActivity;
import com.mounacheikhna.reactiveapp.ui.search.SearchActivity;

import butterknife.ButterKnife;

/**
 * Created by m.cheikhna on 28/03/16.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                //.withHeaderBackground(R.drawable.header)
                .addProfiles(
                        new ProfileDrawerItem().withName("Leila").withEmail("example@gmail.com")
                        //.withIcon(ContextCompat.getDrawable(this, R.drawable.women))
                )
                .withOnAccountHeaderListener((view, profile, currentProfile) -> false)
                .build();

        new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.search)
                                .withIcon(GoogleMaterial.Icon.gmd_search)
                                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                                    startActivity(new Intent(BaseActivity.this, SearchActivity.class));
                                    return true;
                                }),
                        new PrimaryDrawerItem().withName(R.string.post)
                                .withIcon(FontAwesome.Icon.faw_plus)
                                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                                    startActivity(new Intent(BaseActivity.this, PostActivity.class));
                                    return true;
                                })
                )
                .build();

    }

    protected abstract int getLayoutId();

}
