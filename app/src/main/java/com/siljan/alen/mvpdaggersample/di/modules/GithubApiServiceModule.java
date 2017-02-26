package com.siljan.alen.mvpdaggersample.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.siljan.alen.mvpdaggersample.BuildConfig;
import com.siljan.alen.mvpdaggersample.common.IRxJavaSchedulers;
import com.siljan.alen.mvpdaggersample.di.scopes.GithubAppScope;
import com.siljan.alen.mvpdaggersample.networking.ApiManager;
import com.siljan.alen.mvpdaggersample.networking.GithubApiService;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */
@Module(includes = {NetworkModule.class, RxJavaSchedulerModule.class})
public class GithubApiServiceModule {

    @Provides
    @GithubAppScope
    public Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
    }

    @Provides
    @GithubAppScope
    public Retrofit provideRetrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.URL_ENDPOINT)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @GithubAppScope
    public GithubApiService provideApiService(Retrofit githubRetrofit) {
        return githubRetrofit.create(GithubApiService.class);
    }

    @Provides
    @GithubAppScope
    ApiManager provideApiManager(GithubApiService apiService, IRxJavaSchedulers schedulers) {
        return new ApiManager(apiService, schedulers);
    }
}
