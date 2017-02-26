package com.siljan.alen.mvpdaggersample.mvp.interactors.impl;

import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;
import com.siljan.alen.mvpdaggersample.mvp.interactors.IRepoListInteractor;
import com.siljan.alen.mvpdaggersample.networking.ApiManager;
import com.siljan.alen.mvpdaggersample.networking.callbacks.GithubRepositoriesCallback;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class RepoListInteractorImpl implements IRepoListInteractor {

    ApiManager mApiManager;

    @Inject
    public RepoListInteractorImpl(ApiManager apiManager) {
        this.mApiManager = apiManager;
    }

    @Override
    public Observable<List<GithubRepoModel>> getGithubRepos() {
        return mApiManager.fetchGithubRepos();
    }
}
