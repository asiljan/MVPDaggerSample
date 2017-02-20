package com.siljan.alen.mvpdaggersample.mvp.presenters.impl;

import com.siljan.alen.mvpdaggersample.data.models.GithubRepoModel;
import com.siljan.alen.mvpdaggersample.mvp.interactors.IRepoListInteractor;
import com.siljan.alen.mvpdaggersample.mvp.listeners.RepoListListener;
import com.siljan.alen.mvpdaggersample.mvp.presenters.IRepoListPresenter;
import com.siljan.alen.mvpdaggersample.mvp.views.RepoListView;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Alen Siljan on 20.2.2017..
 * alen.siljan@gmail.com
 */

public class RepoListPresenterImpl implements IRepoListPresenter, RepoListListener {

    RepoListView mRepoView;
    IRepoListInteractor mInteractor;

    @Inject
    public RepoListPresenterImpl(RepoListView repoListView, IRepoListInteractor interactor) {
        this.mRepoView = repoListView;
        this.mInteractor = interactor;
    }

    @Override
    public void onStart() {
        mRepoView.onShowLoadingLayout();
        mInteractor.fetchGithubRepos(this);
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    //callback methods
    @Override
    public void onSuccess(List<GithubRepoModel> repositories) {
        mRepoView.onHideLoadingLayout();
        mRepoView.onRepositoriesFetched(repositories);
    }

    @Override
    public void onError(String msg) {
        mRepoView.onHideLoadingLayout();
        mRepoView.onError(msg);
    }
}
