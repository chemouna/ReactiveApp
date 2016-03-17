package com.mounacheikhna.reactiveapp.ui.search;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.mounacheikhna.reactiveapp.AppComponent;
import com.mounacheikhna.reactiveapp.R;
import com.mounacheikhna.reactiveapp.ReactiveApp;
import com.mounacheikhna.reactiveapp.annotation.ScopeSingleton;
import com.mounacheikhna.reactiveapp.api.geonames.model.Geonames;
import com.mounacheikhna.reactiveapp.base.BaseComponent;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
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
    DaggerSearchView_SearchComponent.builder()
        .appComponent(ReactiveApp.get(getContext()).getComponent())
        .build()
        .inject(this);

  }

  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    this.subscriptions = new CompositeSubscription();

    final Subscription subscription = RxTextView.textChanges(departure)
        .debounce(400, TimeUnit.MILLISECONDS, computation())
        .flatMap(charSequence -> searchPresenter.searchPlace(charSequence.toString()))
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<Geonames>() {
          @Override public void onCompleted() {
            Log.i("TEST", " onCompleted ");
          }

          @Override public void onError(Throwable e) {
            Log.i("TEST", " onError " + e);
          }

          @Override public void onNext(Geonames geonames) {
            Log.i("TEST", " onNext " + geonames);
          }
        });
    subscriptions.add(subscription);
  }

  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    this.subscriptions.unsubscribe();
  }


  protected void onFinishInflate() {
    super.onFinishInflate();
    if (isInEditMode()) return;
  }


  @ScopeSingleton(SearchComponent.class)
  @dagger.Component(dependencies = AppComponent.class)
  public interface SearchComponent extends BaseComponent {
    void inject(SearchView searchView);
  }


}
