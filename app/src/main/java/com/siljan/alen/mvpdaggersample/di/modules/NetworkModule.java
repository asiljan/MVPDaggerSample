package com.siljan.alen.mvpdaggersample.di.modules;

import android.content.Context;

import com.siljan.alen.mvpdaggersample.di.scopes.GithubAppScope;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */
@Module(includes = AppModule.class)
public class NetworkModule {

    @Provides
    @GithubAppScope
    public File provideCacheFile(Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @Provides
    @GithubAppScope
    public Cache provideCache(File cacheFile) {
        try {
            int cacheSize = 10 * 1024 * 1024;
            return new Cache(cacheFile, cacheSize);
        } catch (Exception e) {
            e.fillInStackTrace();
            return null;
        }
    }

    @Provides
    @GithubAppScope
    public HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return loggingInterceptor;
    }

    @Provides
    @GithubAppScope
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }
}
