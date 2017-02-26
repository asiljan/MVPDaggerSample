package com.siljan.alen.mvpdaggersample.di.components;

import com.siljan.alen.mvpdaggersample.common.IRxJavaSchedulers;
import com.siljan.alen.mvpdaggersample.di.modules.GithubApiServiceModule;
import com.siljan.alen.mvpdaggersample.di.modules.PicassoModule;
import com.siljan.alen.mvpdaggersample.di.modules.RepoListModule;
import com.siljan.alen.mvpdaggersample.di.modules.RxJavaSchedulerModule;
import com.siljan.alen.mvpdaggersample.di.scopes.GithubAppScope;
import com.siljan.alen.mvpdaggersample.networking.GithubApiService;
import com.squareup.picasso.Picasso;

import dagger.Component;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */
@GithubAppScope
@Component(modules = {GithubApiServiceModule.class, PicassoModule.class})
public interface GithubAppComponent {

    Picasso picasso();

    GithubApiService githubService();

    IRxJavaSchedulers schedulers();

    RepoListComponent newRepoListComponent(RepoListModule repoListModule);
}
