package com.siljan.alen.mvpdaggersample.di.modules;

import com.siljan.alen.mvpdaggersample.common.IRxJavaSchedulers;
import com.siljan.alen.mvpdaggersample.di.scopes.GithubAppScope;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Alen Siljan on 26.2.2017..
 * alen.siljan@gmail.com
 */
@Module
public class RxJavaSchedulerModule {

    @Provides
    @GithubAppScope
    IRxJavaSchedulers provideSchedulers() {
        return new IRxJavaSchedulers() {
            @Override
            public Scheduler io() {
                return Schedulers.io();
            }

            @Override
            public Scheduler mainThread() {
                return AndroidSchedulers.mainThread();
            }
        };
    }
}
