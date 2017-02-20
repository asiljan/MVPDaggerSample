package com.siljan.alen.mvpdaggersample;

import android.app.Application;

import com.siljan.alen.mvpdaggersample.di.components.DaggerGithubAppComponent;
import com.siljan.alen.mvpdaggersample.di.components.GithubAppComponent;
import com.siljan.alen.mvpdaggersample.di.modules.AppModule;

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
