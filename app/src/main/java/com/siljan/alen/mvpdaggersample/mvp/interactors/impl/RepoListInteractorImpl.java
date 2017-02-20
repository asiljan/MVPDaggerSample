package com.siljan.alen.mvpdaggersample.mvp.interactors.impl;

import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;
import com.siljan.alen.mvpdaggersample.mvp.interactors.IRepoListInteractor;
import com.siljan.alen.mvpdaggersample.mvp.listeners.RepoListListener;
import com.siljan.alen.mvpdaggersample.networking.ApiManager;
import com.siljan.alen.mvpdaggersample.networking.callbacks.GithubRepositoriesCallback;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class RepoListInteractorImpl implements IRepoListInteractor, GithubRepositoriesCallback {

    private RepoListListener mListener;

    ApiManager mApiManager;

    @Inject
    public RepoListInteractorImpl(ApiManager apiManager) {
        this.mApiManager = apiManager;
    }

    @Override
    public void fetchGithubRepos(RepoListListener listListener) {
        this.mListener = listListener;
        mApiManager.fetchGithubRepositories(this);
    }

    @Override
    public void onSuccess(List<GithubRepoModel> repositories) {
        mListener.onSuccess(repositories);
    }

    @Override
    public void onError(String msg) {
        mListener.onError(msg);
    }
}
