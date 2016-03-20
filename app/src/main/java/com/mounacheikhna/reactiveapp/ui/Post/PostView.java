package com.mounacheikhna.reactiveapp.ui.Post;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.ButterKnife;

import com.mounacheikhna.reactiveapp.AppComponent;
import com.mounacheikhna.reactiveapp.R;
import com.mounacheikhna.reactiveapp.ReactiveApp;
import com.mounacheikhna.reactiveapp.annotation.ScopeSingleton;
import com.mounacheikhna.reactiveapp.base.BaseComponent;

import javax.inject.Inject;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by cheikhnamouna on 3/14/16.
 */
public class PostView extends LinearLayout implements PostScreen {

  @Inject PostPresenter postPresenter;

  private CompositeSubscription subscriptions;

  public PostView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  private void init(Context context) {
    if (isInEditMode()) return;
    final View view = LayoutInflater.from(context).inflate(R.layout.post, this, true);
    setOrientation(VERTICAL);
    setClipToPadding(false);
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

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }

  @Override
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    subscriptions.unsubscribe();
  }

  @ScopeSingleton(PostComponent.class)
  @dagger.Component(dependencies = AppComponent.class)
  public interface PostComponent extends BaseComponent {
    void inject(PostView postView);
  }

}
