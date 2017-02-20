package com.siljan.alen.mvpdaggersample;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.siljan.alen.mvpdaggersample.di.components.DaggerGithubAppComponent;
import com.siljan.alen.mvpdaggersample.di.components.GithubAppComponent;
import com.siljan.alen.mvpdaggersample.di.modules.AppModule;
import com.siljan.alen.mvpdaggersample.networking.GithubApiService;
import com.squareup.picasso.Picasso;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class MyApplication extends Application {

    private static MyApplication instance;
    private GithubAppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        setInstance(this);
        //// TODO: 20.2.2017. init other stuff i.e fabric

        appComponent = DaggerGithubAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static void setInstance(MyApplication instance) {
        MyApplication.instance = instance;
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public GithubAppComponent getAppComponent() {
        return appComponent;
    }
}
