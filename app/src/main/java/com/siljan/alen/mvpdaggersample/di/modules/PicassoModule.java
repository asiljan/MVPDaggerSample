package com.siljan.alen.mvpdaggersample.di.modules;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.siljan.alen.mvpdaggersample.di.scopes.GithubAppScope;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */
@Module(includes = {AppModule.class, NetworkModule.class})
public class PicassoModule {

    @Provides
    @GithubAppScope
    public Picasso providePicasso(Context context, OkHttp3Downloader okHttp3Downloader) {
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    @GithubAppScope
    public OkHttp3Downloader provideOkHttp3Downloader(OkHttpClient okHttpClient) {
        return new OkHttp3Downloader(okHttpClient);
    }
}
