package com.mounacheikhna.reactiveapp.ui.Post;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import com.mounacheikhna.reactiveapp.AppComponent;
import com.mounacheikhna.reactiveapp.R;
import com.mounacheikhna.reactiveapp.ReactiveApp;
import com.mounacheikhna.reactiveapp.annotation.ScopeSingleton;
import com.mounacheikhna.reactiveapp.base.BaseComponent;
import com.mounacheikhna.reactiveapp.ui.search.DaggerSearchView_SearchComponent;

import javax.inject.Inject;

import butterknife.OnClick;
import rx.subscriptions.CompositeSubscription;

import static android.support.design.widget.Snackbar.LENGTH_SHORT;

/**
 * Created by cheikhnamouna on 3/14/16.
 */
public class PostView extends LinearLayout implements PostScreen {

  @Bind(R.id.top_container)
  ViewGroup container;

  @Inject PostPresenter postPresenter;

  private CompositeSubscription subscriptions;

  public PostView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  private void init(Context context) {
    final View view = LayoutInflater.from(context).inflate(R.layout.post, this, true);
    ButterKnife.bind(this, view);
    DaggerPostView_PostComponent.builder()
            .appComponent(ReactiveApp.get(getContext()).getComponent())
            .build()
            .inject(this);
  }

  @Override
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    subscriptions = new CompositeSubscription();
  }

  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    subscriptions.unsubscribe();
  }

  @OnClick(R.id.post)
  public void post() {
    Snackbar.make(container, R.string.trip_published, LENGTH_SHORT).show();
  }

  @ScopeSingleton(PostComponent.class)
  @dagger.Component(dependencies = AppComponent.class)
  public interface PostComponent extends BaseComponent {
    void inject(PostView postView);
  }

}
