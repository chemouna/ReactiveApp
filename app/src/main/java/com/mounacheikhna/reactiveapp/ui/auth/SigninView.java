package com.mounacheikhna.reactiveapp.ui.auth;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.mounacheikhna.reactiveapp.AppComponent;
import com.mounacheikhna.reactiveapp.R;
import com.mounacheikhna.reactiveapp.ReactiveApp;
import com.mounacheikhna.reactiveapp.annotation.ScopeSingleton;
import com.mounacheikhna.reactiveapp.base.BaseComponent;

import butterknife.ButterKnife;

/**
 * Created by m.cheikhna on 20/03/16.
 */
public class SigninView extends LinearLayout implements SigninScreen {

    public SigninView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(Context context) {
        if (isInEditMode()) return;
        final View view = LayoutInflater.from(context).inflate(R.layout.signin, this, true);
        setOrientation(VERTICAL);
        setClipToPadding(false);
        ButterKnife.bind(this, view);

        DaggerSigninView_SigninComponent.builder()
                .appComponent(ReactiveApp.get(getContext()).getComponent())
                .build()
                .inject(this);
    }

    @ScopeSingleton(SigninComponent.class)
    @dagger.Component(dependencies = AppComponent.class)
    public interface SigninComponent extends BaseComponent {
        void inject(SigninView signinView);
    }

}
