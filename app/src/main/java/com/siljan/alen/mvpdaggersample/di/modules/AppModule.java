package com.siljan.alen.mvpdaggersample.di.modules;

import android.content.Context;

import com.siljan.alen.mvpdaggersample.MyApplication;
import com.siljan.alen.mvpdaggersample.di.scopes.GithubAppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */
@Module
public class AppModule {
    private final MyApplication application;

    public AppModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    @GithubAppScope
    public Context provideContext() {
        return application.getApplicationContext();
    }
}
