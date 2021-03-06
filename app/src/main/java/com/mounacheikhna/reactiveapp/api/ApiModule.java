package com.mounacheikhna.reactiveapp.api;

import android.content.Context;
import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.mounacheikhna.reactiveapp.BuildConfig;
import com.mounacheikhna.reactiveapp.annotation.ApiClient;
import com.mounacheikhna.reactiveapp.annotation.ApplicationContext;
import com.mounacheikhna.reactiveapp.api.geonames.GeonamesApi;
import com.squareup.moshi.Moshi;
import com.squareup.picasso.Picasso;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by cheikhnamouna on 3/15/16.
 */
@Module
public class ApiModule {

  @Provides @Singleton Moshi provideMoshi() {
    return new Moshi.Builder().build();
  }

  @Provides @Singleton @ApiClient OkHttpClient provideApiClient(OkHttpClient client/*,
      @NetworkInterceptors List<Interceptor> networkInterceptors*/) {
    //client.networkInterceptors().addAll(networkInterceptors);
    return client;
  }

  @Provides @Singleton OkHttpClient provideOkHttpClient() {
    return new OkHttpClient.Builder()
            .addInterceptor(new StethoInterceptor())
            .build();
  }

  @Provides @Singleton Retrofit provideRetrofit(
      @ApiClient OkHttpClient apiClient, Moshi moshi) {
    return new Retrofit.Builder().client(apiClient)
        .baseUrl(HttpUrl.parse(BuildConfig.GEONAME_SERVICE_API))
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();
  }

  @Provides @Singleton GeonamesApi provideGeonamesApi(Retrofit retrofit) {
    return retrofit.create(GeonamesApi.class);
  }

  @Provides @Singleton Picasso providePicasso(@ApplicationContext Context context) {
    return new Picasso.Builder(context).build();
  }

}

