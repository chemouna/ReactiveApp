package com.mounacheikhna.reactiveapp.ui.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.mounacheikhna.trips.R;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

import static rx.schedulers.Schedulers.computation;

/**
 * Created by cheikhnamouna on 3/14/16.
 */
public class SearchView extends LinearLayout implements SearchScreen {

  @Bind(R.id.departure) EditText departure;
  @Bind(R.id.arrival) EditText arrival;

  @Inject SearchPresenter searchPresenter;

  private CompositeSubscription subscriptions;

  public SearchView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init(context);
  }

  //TODO: should have a layout with 2 fields both search and each return result and get displayed

  private void init(Context context) {
    final View view = LayoutInflater.from(context).inflate(R.layout.search, this, true);
    ButterKnife.bind(this, view);
    //TODO: inject dagger here 
    RxTextView.textChanges(departure)
        .debounce(400, TimeUnit.MILLISECONDS, computation()) //
        .observeOn(AndroidSchedulers.mainThread()) //
        .subscribe(new Action1<CharSequence>() {
          @Override public void call(CharSequence charSequence) {
            searchPresenter.SearchPlace(charSequence.toString());
          }
        });
        //TODO: throttle and all ne
  }

  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.subscriptions = new CompositeSubscription();
  }

  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.subscriptions.unsubscribe();
  }


  protected void onFinishInflate() {
    super.onFinishInflate();
    if (isInEditMode()) return;
  }
}
