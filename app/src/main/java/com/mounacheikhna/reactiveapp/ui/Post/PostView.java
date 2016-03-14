package com.mounacheikhna.reactiveapp.ui.Post;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.ButterKnife;
import com.mounacheikhna.reactiveapp.R;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by cheikhnamouna on 3/14/16.
 */
public class PostView extends LinearLayout implements PostScreen {

  private CompositeSubscription mSubscriptions;

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
    mSubscriptions = new CompositeSubscription(); //TODO: add a way to auto handle subscriptions to not worry about it anymore
  }

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    ButterKnife.bind(this);
  }
}
